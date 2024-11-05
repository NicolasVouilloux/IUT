using Microsoft.Win32;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System;
using static System.Exception;

namespace BuggedFileReader
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private OpenFileDialog ofd = new OpenFileDialog();
        private string lastOpenFile = "";
        public MainWindow()
        {
            InitializeComponent();
            ofd.InitialDirectory = Directory.GetCurrentDirectory();
        }

        /**
         * Exceptions are not handled
         */
        private void BTNOpenFile_Click(object sender, RoutedEventArgs e)
        {
            lastOpenFile = TBXFileName.Text;
            loadFile();
        }

        /**
         * This method should open a Dialog window
         */
        private void BTNOpenDialog_Click(object sender, RoutedEventArgs e)
        {
            bool? result = ofd.ShowDialog();
            if (result!=null && result == true)
            {
                lastOpenFile = ofd.FileName;
                loadFile();    
            }
        }
        private int wordCount()
        {
            int count = 0;
            foreach(string line in TBKContent.Text.Split('\n'))
            {
                foreach(string word in line.Split(' ')){
                    count++;
                }
                count++;
            }
            return count;
        }

        /**
         * This method should open the file... Where does the class "File" come from?
         */
        private void loadFile()
        {
            string text;
            string curFile = TBXFileName.Text;
            try
            {
                text = File.ReadAllText(lastOpenFile);
                TBKContent.Text = text;
                LBLWordCountValue.Content = wordCount();
            }
            catch (Exception ex)
            {
                if (curFile == "")
                    MessageBox.Show("Bro What are u even trying to do ?", ex.ToString());
                else if (!File.Exists(curFile))
                    MessageBox.Show("Bro u cant even write ur file correcly", ex.ToString());
            }
        }

        /**
         * This method must be triggered by the combobox. Did we configure all the possible options?
         */
        private void CBXCase_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ComboBox cbx = (ComboBox)sender;
            if(cbx.SelectedIndex == 0 && lastOpenFile != "")
            {
                loadFile();
            }
            if(cbx.SelectedIndex == 1 && lastOpenFile != "")
            {
                loadFile();
                TBKContent.Text = TBKContent.Text.ToUpper();
            }
            if (cbx.SelectedIndex == 2 && lastOpenFile != "")
            {
                loadFile();
                TBKContent.Text = TBKContent.Text.ToLower();
            }
        }
    }
}
