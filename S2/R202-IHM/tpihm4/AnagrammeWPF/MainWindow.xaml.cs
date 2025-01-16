using Microsoft.VisualBasic;
using System;
using System.Collections.Generic;
using System.Configuration.Internal;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using static System.Net.Mime.MediaTypeNames;

namespace AnagrammeWPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        
        private string[] mots;
        private String[] wordsArray;
        private int indexWordToGuess;
        private int MaxNumberOfTry = 10;
        private int NumberOfRemainingTry ;
        private int NumberOfTry=0 ;
        private int NumberOfGames = 1;

        public MainWindow()
        {
            InitializeComponent();
        }
        private void Initialize()
        {
            wordsArray = new String[] { "CSHARP1", "CSHARP2", "CSHARP3", "CSHARP4", "CSHARP5", "CSHARP6"};
            NewGame();  
        }
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            Initialize();
        }

        private String Jumble(String word)
        {
            StringBuilder jumbleSB = new StringBuilder();
            jumbleSB.Append(word);
            int lengthSB = jumbleSB.Length;
            Random rand = new Random();

            for (int i = 0; i < lengthSB; i++)
            {
                int index1 = (rand.Next() % lengthSB);
                int index2 = (rand.Next() % lengthSB);

                (jumbleSB[index2], jumbleSB[index1]) = (jumbleSB[index1], jumbleSB[index2]);

            }
            return new string (jumbleSB.ToString());
        }

        private void NewGame()
        {
            Random r = new Random();
            indexWordToGuess = r.Next(0, wordsArray.Length);
            LBLWordGuess.Content = Jumble(wordsArray[indexWordToGuess]);
            NumberOfRemainingTry = MaxNumberOfTry;
            LISTPrevGuess.Items.Clear();
            NumberOfTry = 0;
            TBXGuess.Text = "";
            LBLTries.Content = "Number of remaining tries : 10";
        }

        private void IncorrectWord()
        {
            LISTGameHistory.Items.Add("Game " + NumberOfGames + " - " + wordsArray[indexWordToGuess] + " Lost - " +  NumberOfTry  + " Tries");
            NumberOfGames++;
            string message = "You lost, too bad. The word was " + wordsArray[indexWordToGuess] + ",\r\n Do you want to play again ?";
            string title = "Lost !";
            MessageBoxResult result = MessageBox.Show(message,title, MessageBoxButton.YesNo);
            if (result == MessageBoxResult.Yes)
                NewGame();
            else 
                this.Close();
        }
        private void CorrectWord()
        {
            LISTGameHistory.Items.Add("Game " + NumberOfGames + " - " + wordsArray[indexWordToGuess] + " Win - "+ NumberOfTry +" Tries");
            NumberOfGames++;
            string message = "Congratulations, you won !!\r\n Do you want to play again ?";
            string title = "Won!";
            MessageBoxResult result = MessageBox.Show(message, title, MessageBoxButton.YesNo);
            if (result == MessageBoxResult.Yes)
                NewGame();
            else
                this.Close();
        }
        private void BTNTest_Click(object sender, RoutedEventArgs e)
        {
            NumberOfTry++;
            string guess = TBXGuess.Text;
            LISTPrevGuess.Items.Add(guess);
            if (TBXGuess.Text == wordsArray[indexWordToGuess])
                CorrectWord();
            else
            {
                NumberOfRemainingTry--;
                LBLTries.Content = "Number of remaining tries : " + NumberOfRemainingTry;
                if (NumberOfRemainingTry == 0)
                    IncorrectWord();
            }
            TBXGuess.Text = "";
        }
        private void BTNNewGame_Click(object sender, RoutedEventArgs e)
        {
            string message = "This will cancel the current game and it\r\nwill be lost. Are you sure ?";
            string title = "Start a new game";
            MessageBoxResult result = MessageBox.Show(message, title, MessageBoxButton.YesNo);
            if (result == MessageBoxResult.Yes)
            {
                LISTGameHistory.Items.Add("Game " + NumberOfGames + " - " + wordsArray[indexWordToGuess] + " Lost - " + NumberOfTry + " Tries");
                NumberOfGames++;
                NewGame();
            }
        }
        private void BTNExit_Click(object sender, RoutedEventArgs e)
        {
            string message = "Do you really want to exit?";
            string title = "Exit";
            MessageBoxResult result = MessageBox.Show(message, title, MessageBoxButton.YesNo);
            if (result == MessageBoxResult.Yes)
            {
                this.Close();
            }
        }
        
        private void TBXGuess_TextChanged(object sender, TextChangedEventArgs e)
        {

        }


    }
}
