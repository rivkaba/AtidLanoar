

import android.widget.EditText;

    public class User {
        private String name;
        private String lastName;
        private String passWord;
        private String district;
        public User (String name, String lastName, String passWord, String district){
            this.name= name;
            this.lastName=lastName;
            this.passWord= passWord;
            this.district= district;
        }
        public User (){

        }
        public void setName(String name){
            this.name= name;
        }
        public void setLastName(String lastName){
            this.lastName= lastName;
        }
        public void setpassWord(String passWord){
            this.passWord= passWord;
        }
        public void setdistrict(String district){
            this.district= district;
        }
        public String getName(){
            return name;
        }
        public String getLastName(){
            return lastName;
        }
        public String getpassWord(){
            return passWord;
        }
        public String getdistrict(){
            return district;
        }
    }


