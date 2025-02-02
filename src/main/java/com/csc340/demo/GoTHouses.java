package com.csc340.demo;

public class GoTHouses{
        public String name;
        public String region;
        public String words;

        public GoTHouses(String name, String region, String words) {
            this.name = name;
            this.region = region;
            this.words = words;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String address) {
            this.region = region;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }

