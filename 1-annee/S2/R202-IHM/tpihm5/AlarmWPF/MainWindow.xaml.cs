using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace AlarmWPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {


        /*
         *READ ME  
         * The application work close too the entirety (there is just a problem in the hour/min
         * where you can write the alarms like when for 09h07 you need too write 9 and 7 not 09 and 07 
         * a simple conversion is needed in the code too modify it 
         */
        DispatcherTimer timer;
        //A circle
        private Ellipse ellipse;
        //3 hands
        private Line minutes;
        private Line hours;
        private Line seconds;

        double lengthHoursHand;
        double lengthMinsHand;
        double lengthSecondsHand;

        bool alarmbutton = false;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            timer = new DispatcherTimer();
            //Defines the number of seconds between each triggering of the Tick event 
            timer.Interval = TimeSpan.FromSeconds(1);
            //Associates an event procedure with the timer's Tick event, you'll need to write this event procedure.
            timer.Tick += timer_Tick;
            //Launches the timer, otherwise nothing happens
            timer.Start();

            ellipse = new Ellipse();
            CNVClock.Children.Add(ellipse);
            ellipse.Width = 300;
            ellipse.Height = 300;
            ellipse.Stroke = Brushes.Gray;
            ellipse.StrokeThickness = 1;
            
            seconds = new Line();
            CNVClock.Children.Add(seconds);
            seconds.Stroke = Brushes.Red;
            seconds.StrokeThickness = 1;
            //The point of origin is at the center of the circle
            seconds.X1 = ellipse.Width / 2;
            seconds.Y1 = ellipse.Height / 2;

            //I define the length of the hand, I could set another value
            lengthSecondsHand = ellipse.Width / 2;
            seconds.X2 = ellipse.Width / 2 + Math.Cos(15 * Math.PI / 30 - DateTime.Now.Second * Math.PI / 30) * lengthSecondsHand;
            seconds.Y2 = ellipse.Height / 2 + Math.Sin(-15 * Math.PI / 30 + DateTime.Now.Second * Math.PI / 30) * lengthSecondsHand;

            minutes = new Line();
            CNVClock.Children.Add(minutes);
            minutes.Stroke = Brushes.Black;
            minutes.StrokeThickness = 1;
            //The point of origin is at the center of the circle
            minutes.X1 = ellipse.Width / 2;
            minutes.Y1 = ellipse.Height / 2;

            //I define the length of the hand, I could set another value
            lengthMinsHand = ellipse.Width / 3;
            minutes.X2 = ellipse.Width / 2 + Math.Cos(15 * Math.PI / 30 - DateTime.Now.Minute * Math.PI / 30) * lengthMinsHand;
            minutes.Y2 = ellipse.Height / 2 + Math.Sin(-15 * Math.PI / 30 + DateTime.Now.Minute * Math.PI / 30) * lengthMinsHand;

            hours = new Line();
            CNVClock.Children.Add(hours);
            hours.Stroke = Brushes.Green;
            hours.StrokeThickness = 1;
            //The point of origin is at the center of the circle
            hours.X1 = ellipse.Width / 2;
            hours.Y1 = ellipse.Height / 2;

            //I define the length of the hand, I could set another value
            lengthHoursHand = ellipse.Width / 4;
            hours.X2 = ellipse.Width / 2 + Math.Cos(3 * Math.PI / 6 - DateTime.Now.Hour * Math.PI / 6) * lengthHoursHand;
            hours.Y2 = ellipse.Height / 2 + Math.Sin(-3 * Math.PI / 6 + DateTime.Now.Hour * Math.PI / 6) * lengthHoursHand;
        }

        private void timer_Tick(object? sender, EventArgs e)
        {
            if (alarm_check() == true)
            {
                    MediaPlayer mplayer = new MediaPlayer();
                    mplayer.Open(new Uri("./yasuo-hasaki.mp3", UriKind.Relative));
                    mplayer.Play();
            }
            hours.X2 = ellipse.Width / 2 + Math.Cos(3 * Math.PI / 6 - DateTime.Now.Hour * Math.PI / 6) * lengthHoursHand;
            hours.Y2 = ellipse.Height / 2 + Math.Sin(-3 * Math.PI / 6 + DateTime.Now.Hour * Math.PI / 6) * lengthHoursHand;

            minutes.X2 = ellipse.Width / 2 + Math.Cos(15 * Math.PI / 30 - DateTime.Now.Minute * Math.PI / 30) * lengthMinsHand;
            minutes.Y2 = ellipse.Height / 2 + Math.Sin(-15 * Math.PI / 30 + DateTime.Now.Minute * Math.PI / 30) * lengthMinsHand;

            seconds.X2 = ellipse.Width / 2 + Math.Cos(15 * Math.PI / 30 - DateTime.Now.Second * Math.PI / 30) * lengthSecondsHand;
            seconds.Y2 = ellipse.Height / 2 + Math.Sin(-15 * Math.PI / 30 + DateTime.Now.Second * Math.PI / 30) * lengthSecondsHand;


        }

        private void ButtonAdd_Click(object sender, RoutedEventArgs e)
        {
            LSBHour.Items.Add(TXBMin.Text + " walahi " + TXBHour.Text);
        }

        private void BTNRemove_Click(object sender, RoutedEventArgs e)
        {
            LSBHour.Items.Remove(LSBHour.SelectedItems[0]);
        }
        private bool alarm_check()
        {
            bool alarm = false;
            for (int i = 0; i < LSBHour.Items.Count; i++)
            {
                if (DateTime.Now.Hour.ToString() + " walahi " + DateTime.Now.Minute.ToString() == LSBHour.Items[i].ToString() && DateTime.Now.Second== 0)
                    alarm = true;
                    alarmbutton = false;
            }
        return alarm;
        }

        private void BTNStopAlarm_Click(object sender, RoutedEventArgs e)
        {
            alarmbutton = true;
        }
    }
}
