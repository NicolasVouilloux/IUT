using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace burgerWPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        
        float Somme = 0;
        float ValAjouter;
        public MainWindow()
        {
            InitializeComponent();
        }

       

        private void CheckBox_Checked(object sender, RoutedEventArgs e)
        {
            /*if (ToggleButton.IsChecked==true)
                AjoutArgent(0.25);
            else 
                EnleveArgent(0.25);
            */ 
            //Beaucoup trop short désoler j'ai bloquer sur le check box
        }
      


        private void ListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
        private void EnleveArgent(float ValAjouter)
        {
            Somme -= ValAjouter;
            LBLSomme.Content = Somme;
        }
        private void AjoutArgent(float ValAjouter)
        {
            Somme += ValAjouter;
            LBLSomme.Content = Somme;
        }
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Merci pour ta commande! La facture d'un montant de " + LBLSomme.Content + " te sera envoyée par SMS.","Commande passer");
        }
    }
}
