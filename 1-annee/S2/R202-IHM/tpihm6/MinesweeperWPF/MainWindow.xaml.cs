using System;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Navigation;
using static System.Reflection.Metadata.BlobBuilder;

namespace MinesweeperWPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int gridSize = 10;      // grid size
        private int nbMines = 10;       // number of mines
        private int nbCellsChecked = 0; // number of cells that have been checked (opened)
        private int[,] matrix;          // matrix preserving grid values (see below)




        public MainWindow()
        {
            InitializeComponent();
        }
        
        private UIElement GetUIElementFromPosition(Grid g, int col, int row)
        {
            return g.Children.Cast<UIElement>().First(e => Grid.GetRow(e) == row && Grid.GetColumn(e) == col);
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            newgame();
        }
        private void newgame()
        {
            matrix = new int[gridSize, gridSize];
            nbCellsChecked = 0;
            GRDGame.Children.Clear();
            GRDGame.ColumnDefinitions.Clear();
            GRDGame.RowDefinitions.Clear();
            for (int i = 0; i < gridSize; i++)
            {
                GRDGame.ColumnDefinitions.Add(new ColumnDefinition() { Width = new GridLength(1, GridUnitType.Star) });
                GRDGame.RowDefinitions.Add(new RowDefinition() { Height = new GridLength(1, GridUnitType.Star) });
            }
            refillTheGrid();
        }
        private void refillTheGrid()
        {
            for (int i =0; i < gridSize; i++)
            {
                for (int j =0; j < gridSize; j++)
                {
                    Border b = new Border();
                    b.BorderThickness = new Thickness(1);
                    b.BorderBrush = new SolidColorBrush(Colors.LightBlue);
                    b.SetValue(Grid.RowProperty, j);
                    b.SetValue(Grid.ColumnProperty, i);
                    GRDGame.Children.Add(b);
                    
                    Grid littlekawaiigrid = new Grid();
                    littlekawaiigrid.SetValue(Grid.RowProperty, j);
                    littlekawaiigrid.SetValue(Grid.ColumnProperty, i);
                    b.Child= littlekawaiigrid;

                    Label label = new Label();
                    label.SetValue(Grid.RowProperty, 0);
                    label.SetValue(Grid.ColumnProperty, 0);
                    label.Content = "0";
                    littlekawaiigrid.Children.Add(label);

                    Button btn = new Button();
                    btn.SetValue(Grid.RowProperty, 0);
                    btn.SetValue(Grid.ColumnProperty, 0);
                    littlekawaiigrid.Children.Add(btn);
                    btn.Click += Button_Click;
                }
            }
            bombfiller();
        }
        
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button btn = (Button)sender;
            //Here I assume that in each grid cell, I have a Border containing a grid containing my button. 
            Border g = (Border)VisualTreeHelper.GetParent(VisualTreeHelper.GetParent(btn));
            int col = Grid.GetColumn(g);
            int row = Grid.GetRow(g);
            if (checkCell(col, row))
                btn.Visibility = Visibility.Hidden;
        }
        private void bombfiller()
        {
        
            for (int i = 0; i < nbMines; i++)
            {
                Random rand = new Random();
                int col = (rand.Next(0,gridSize));
                int row = (rand.Next(0, gridSize));

                Border border = (Border)GetUIElementFromPosition(GRDGame, col, row);
                Grid grid = (Grid)VisualTreeHelper.GetChild(border, 0);
                Label lbl = (Label)VisualTreeHelper.GetChild(grid, 0);
                while (IsABomb(col,row))
                {

                    col = (rand.Next(0, gridSize));
                    row = (rand.Next(0, gridSize));

                    border = (Border)GetUIElementFromPosition(GRDGame, col, row);
                    grid = (Grid)VisualTreeHelper.GetChild(border, 0);
                    lbl = (Label)VisualTreeHelper.GetChild(grid, 0);
                }
                lbl.Content = "Bomba";
                matrix[col, row] = -1;
            }

            for (int col =0; col<gridSize; col++)
            {
                for (int row = 0; row < gridSize; row++)
                {
                    int numberofnearbomb = 0;
                    if (!IsABomb(col, row))
                    {
                        for (int i = Math.Max(0, col - 1); i <= Math.Min(gridSize - 1, col + 1); i++)
                        {
                            for (int j = Math.Max(0, row - 1); j <= Math.Min(gridSize - 1, row + 1); j++)
                            {
                            if (IsABomb(i, j))
                                numberofnearbomb++;
                            }
                        }
                    Border border = (Border)GetUIElementFromPosition(GRDGame, col, row);
                    Grid grid = (Grid)VisualTreeHelper.GetChild(border, 0);
                    Label lbl = (Label)VisualTreeHelper.GetChild(grid, 0);
                    lbl.Content = numberofnearbomb.ToString();
                        matrix[col, row] = numberofnearbomb;  
                    }

                }
            } 
                
        }
        private bool IsABomb(int col, int row)
        {
            bool IsItMan = false;
            
            if (matrix[col,row] == -1) { 
                IsItMan= true;
            }

            return IsItMan;
        }


        private bool checkCell (int col,int row)
        {
            Border border = (Border)GetUIElementFromPosition(GRDGame, col, row);
            Grid grid = (Grid)VisualTreeHelper.GetChild(border, 0);
            Button btn = (Button)VisualTreeHelper.GetChild(grid, 1);
            if (btn.Visibility == Visibility.Visible)
            {
                btn.Visibility = Visibility.Hidden;
                nbCellsChecked++;
                if (IsABomb(col,row))
                {
                    MessageBox.Show("Bro lost bahaha", "LOSER");
                    newgame();
                    return true;
                }
                else if (((gridSize*gridSize)-nbCellsChecked) == nbMines)
                {
                    MessageBox.Show("Lemekestbo", "DAMN");
                    newgame();
                    return true;
                } 
                if (matrix[col,row]== 0) {
                    for (int i = Math.Max(0, col - 1); i <= Math.Min(gridSize - 1, col + 1); i++)
                    {
                        for (int j = Math.Max(0, row - 1); j <= Math.Min(gridSize - 1, row + 1); j++)
                        {
                            bool resulat = checkCell(i, j);
                            if (resulat)
                            {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            int GridSize;
            Int32.TryParse(gridsizetxt.Text, out GridSize);
            gridSize= GridSize;

            int NbBomb;
            Int32.TryParse(nbbombtxttxt.Text, out NbBomb);
            nbMines = NbBomb;

            newgame();
        }
    }
}
