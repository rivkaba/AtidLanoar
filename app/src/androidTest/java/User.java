

import android.widget.EditText;

    public class User {
        private String ID;
        private boolean approve;
        private String email;
        private String fname;
        private String lname;
        private String phone;
        private String team;
        private String teamName;
        private String type;

        public User(String ID, boolean approve, String email, String fname, String lname, String phone, String team, String teamName, String type) {
            this.ID = ID;
            this.approve = approve;
            this.email = email;
            this.fname = fname;
            this.lname = lname;
            this.phone = phone;
            this.team = team;
            this.teamName = teamName;
            this.type = type;
        }

        public User() {

        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public void setApprove(boolean approve) {
            this.approve = approve;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getID() {
            return ID;
        }

        public String getEmail() {
            return email;
        }

        public String getFname() {
            return fname;
        }

        public String getLname() {
            return lname;
        }

        public String getPhone() {
            return phone;
        }

        public String getTeam() {
            return team;
        }

        public String getTeamName() {
            return teamName;
        }

        public String getType() {
            return type;
        }

        public boolean isApprove() {
            return approve;
        }

    }


