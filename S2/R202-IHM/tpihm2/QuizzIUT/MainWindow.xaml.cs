using System;
using System.Collections.Generic;
using System.Linq;
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

namespace QuizzIUT
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int count = -1;
        private int good = 0;
        private int bad = 0;
        private string[] question = { "What is the ad stat of Infinity Edge",
            "What is the name of the ultimate of Zeri ?",
            "What is the foot size of Zeri ?",
            "What is the InGame Name of Nicolas ?",
            "Am i loved ?",
            "What is the word you can say to flame ",
            "Is zeri the best champ in lol ?",
            "Do u think i love Zeri ?",
            "how can u be so strange ?",
            "Ewwww are u 5 ?" };
        private string[] answer = {"65",
            "Lightning Crash",
            "8",
            "ZeriToeLicker",
            "Yes emperor of the seven seas, guardian of the legendary ring",
            "KissYourself",
            "Yes",
            "Yes",
            "Sowwy",
            "Yes"};
        public MainWindow()
        {
            InitializeComponent();
        }

        private void WNDMainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            NextQuestion();
        }

        private void BTNValidate_Click(object sender, RoutedEventArgs e)
        {
            //create local variables for the data
            string correctAnswer = answer[count]; 
            string userAnswer = TBXResponse.Text;
            //test to verifie the user answer and the answer there is in our code
            if (userAnswer == correctAnswer) {
                string message = "Damn what a good boyy";
                MessageBox.Show(message);
                good++;
                LBLCorrectAnswersvalues.Content = good;
            }
            else
            {
                string message = ("wadafakbro ? The answer was "+ correctAnswer);
                MessageBox.Show(message);
                bad++;
                LBLIncorrectAnswersvalues.Content = bad;
            }
            //call to lauche the program another time
            NextQuestion();
        }
        private void SetDarkMod()
        {
            this.Background = Brushes.DarkGray;
            LBLCorrectAnswers.Foreground = Brushes.Black;
            LBLIncorrectAnswers.Foreground = Brushes.Black;
            LBLCorrectAnswersvalues.Foreground = Brushes.Black;
            LBLIncorrectAnswersvalues.Foreground = Brushes.Black;
            LBLtitle.Foreground = Brushes.Black;
            LBLQuestion.Foreground = Brushes.Black;
            LBLtitle.Foreground =  Brushes.Black;
            LBLtitlehided.Foreground =  Brushes.Black;
            BTNValidate.Background = Brushes.WhiteSmoke;
            BTNValidate.Foreground = Brushes.Black;
            TBXResponse.Background = Brushes.WhiteSmoke;
            TBXResponse.Foreground = Brushes.Black;
            TBXResponse.BorderBrush = Brushes.Black;
            sun.Source = new BitmapImage(new Uri("/sun.png", UriKind.Relative));
            moon.Source = new BitmapImage(new Uri("/moon.png", UriKind.Relative));

        }
        private void SetLightMod()
        {
            this.Background = new SolidColorBrush(Color.FromRgb(21,21,21));
            LBLCorrectAnswers.Foreground = Brushes.HotPink;
            LBLIncorrectAnswers.Foreground = Brushes.HotPink;
            LBLCorrectAnswersvalues.Foreground = Brushes.HotPink;
            LBLIncorrectAnswersvalues.Foreground = Brushes.HotPink;
            LBLtitle.Foreground = Brushes.HotPink;
            LBLQuestion.Foreground = Brushes.HotPink;
            LBLtitle.Foreground = Brushes.HotPink;
            LBLtitlehided.Foreground = Brushes.HotPink;
            BTNValidate.Background = Brushes.WhiteSmoke;
            BTNValidate.Foreground = Brushes.HotPink;
            TBXResponse.Background = Brushes.Black;
            TBXResponse.Foreground = Brushes.HotPink;
            TBXResponse.BorderBrush = Brushes.HotPink;
            sun.Source = new BitmapImage(new Uri("/sun-modified.png", UriKind.Relative));
            moon.Source = new BitmapImage(new Uri("/moon-modified.png", UriKind.Relative));
        }
        private void NextQuestion()
        {
            count++;
            if (count == question.Length) { count = 0; }
            LBLQuestion.Content = question[count];
        }

        private void SDRNightMode_ValueChanged_1(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (SDRNightMode.Value == 1)
            {
                SetLightMod();
            }
            else if (SDRNightMode.Value == 0) SetDarkMod();
        }
    }
}
