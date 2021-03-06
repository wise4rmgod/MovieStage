package com.example.multikskills.moviestage.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

public class MovieResult {

    /**
     * page : 1
     * total_results : 19795
     * total_pages : 990
     * results : [{"vote_count":273,"id":353081,"video":false,"vote_average":7.5,"title":"Mission: Impossible - Fallout","popularity":456.906,"poster_path":"/AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg","original_language":"en","original_title":"Mission: Impossible - Fallout","genre_ids":[12,28,53],"backdrop_path":"/5qxePyMYDisLe8rJiBYX8HKEyv2.jpg","adult":false,"overview":"When an IMF mission ends badly, the world is faced with dire consequences. As Ethan Hunt takes it upon himself to fulfil his original briefing, the CIA begin to question his loyalty and his motives. The IMF team find themselves in a race against time, hunted by assassins while trying to prevent a global catastrophe.","release_date":"2018-07-25"},{"vote_count":2292,"id":351286,"video":false,"vote_average":6.6,"title":"Jurassic World: Fallen Kingdom","popularity":343.96,"poster_path":"/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg","original_language":"en","original_title":"Jurassic World: Fallen Kingdom","genre_ids":[28,12,878],"backdrop_path":"/3s9O5af2xWKWR5JzP2iJZpZeQQg.jpg","adult":false,"overview":"Several years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar. Claire Dearing, the former park manager and founder of the Dinosaur Protection Group, recruits Owen Grady to help prevent the extinction of the dinosaurs once again.","release_date":"2018-06-06"},{"vote_count":6057,"id":299536,"video":false,"vote_average":8.4,"title":"Avengers: Infinity War","popularity":265.587,"poster_path":"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg","original_language":"en","original_title":"Avengers: Infinity War","genre_ids":[12,878,14,28],"backdrop_path":"/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg","adult":false,"overview":"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.","release_date":"2018-04-25"},{"vote_count":4207,"id":177677,"video":false,"vote_average":7.1,"title":"Mission: Impossible - Rogue Nation","popularity":239.022,"poster_path":"/z2sJd1OvAGZLxgjBdSnQoLCfn3M.jpg","original_language":"en","original_title":"Mission: Impossible - Rogue Nation","genre_ids":[28,12,53],"backdrop_path":"/8XeLfNQrDmFQmPTqxapfWUnKiLf.jpg","adult":false,"overview":"Ethan and team take on their most impossible mission yet, eradicating the Syndicate - an International rogue organization as highly skilled as they are, committed to destroying the IMF.","release_date":"2015-07-23"},{"vote_count":3653,"id":954,"video":false,"vote_average":6.8,"title":"Mission: Impossible","popularity":238.544,"poster_path":"/vmj2PzTLC6xJvshpq8SlaYE3gbd.jpg","original_language":"en","original_title":"Mission: Impossible","genre_ids":[12,28,53],"backdrop_path":"/tjQHn6xW5BiB1RJ3OZIPDzIOSkF.jpg","adult":false,"overview":"When Ethan Hunt, the leader of a crack espionage team whose perilous operation has gone awry with no explanation, discovers that a mole has penetrated the CIA, he's surprised to learn that he's the No. 1 suspect. To clear his name, Hunt now must ferret out the real double agent and, in the process, even the score.","release_date":"1996-05-22"},{"vote_count":4986,"id":56292,"video":false,"vote_average":6.9,"title":"Mission: Impossible - Ghost Protocol","popularity":164.876,"poster_path":"/s58mMsgIVOFfoXPtwPWJ3hDYpXf.jpg","original_language":"en","original_title":"Mission: Impossible - Ghost Protocol","genre_ids":[28,53,12],"backdrop_path":"/pc7a2qrIkIxzqWGqcexd3mHzIxy.jpg","adult":false,"overview":"Ethan Hunt and his team are racing against time to track down a dangerous terrorist named Hendricks, who has gained access to Russian nuclear launch codes and is planning a strike on the United States. An attempt to stop him ends in an explosion causing severe destruction to the Kremlin and the IMF to be implicated in the bombing, forcing the President to disavow them. No longer being aided by the government, Ethan and his team chase Hendricks around the globe, although they might still be too late to stop a disaster.","release_date":"2011-12-07"},{"vote_count":3243,"id":383498,"video":false,"vote_average":7.6,"title":"Deadpool 2","popularity":148.978,"poster_path":"/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg","original_language":"en","original_title":"Deadpool 2","genre_ids":[28,35,878],"backdrop_path":"/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg","adult":false,"overview":"Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.","release_date":"2018-05-15"},{"vote_count":945,"id":363088,"video":false,"vote_average":7,"title":"Ant-Man and the Wasp","popularity":131.084,"poster_path":"/rv1AWImgx386ULjcf62VYaW8zSt.jpg","original_language":"en","original_title":"Ant-Man and the Wasp","genre_ids":[28,12,14,35,878],"backdrop_path":"/6P3c80EOm7BodndGBUAJHHsHKrp.jpg","adult":false,"overview":"As Scott Lang awaits expiration of his term of house detention, Hope van Dyne and Dr. Hank Pym involve him in a scheme to rescue Mrs. van Dyne from the micro-universe into which she has fallen, while two groups of schemers converge on them with intentions of stealing Dr. Pym's inventions.","release_date":"2018-07-04"},{"vote_count":3588,"id":158015,"video":false,"vote_average":6.1,"title":"The Purge","popularity":125.495,"poster_path":"/tGGJOuLHX7UDlTz57sjfhW1qreP.jpg","original_language":"en","original_title":"The Purge","genre_ids":[878,27,53],"backdrop_path":"/1sZ9Nnic1ldHhHttAMDmNxaNM04.jpg","adult":false,"overview":"Given the country's overcrowded prisons, the U.S. government begins to allow 12-hour periods of time in which all illegal activity is legal. During one of these free-for-alls, a family must protect themselves from a home invasion.","release_date":"2013-05-31"},{"vote_count":2764,"id":956,"video":false,"vote_average":6.5,"title":"Mission: Impossible III","popularity":125.305,"poster_path":"/qjy8ABAbWooV4jLG6UjzDHlv4RB.jpg","original_language":"en","original_title":"Mission: Impossible III","genre_ids":[12,28,53],"backdrop_path":"/kOELgNnVt6EGCjtDXx85YUw6p8X.jpg","adult":false,"overview":"Retired from active duty to train new IMF agents, Ethan Hunt is called back into action to confront sadistic arms dealer, Owen Davian. Hunt must try to protect his girlfriend while working with his new team to complete the mission.","release_date":"2006-05-03"},{"vote_count":2700,"id":955,"video":false,"vote_average":6,"title":"Mission: Impossible II","popularity":122.351,"poster_path":"/eRaEC0vf5q5TSvaoJPwGTt2wa9T.jpg","original_language":"en","original_title":"Mission: Impossible II","genre_ids":[12,28,53],"backdrop_path":"/bDdVZNvxb670EMlZqeIy6RdyJ4V.jpg","adult":false,"overview":"With computer genius Luther Stickell at his side and a beautiful thief on his mind, agent Ethan Hunt races across Australia and Spain to stop a former IMF agent from unleashing a genetically engineered biological weapon called Chimera. This mission, should Hunt choose to accept it, plunges him into the center of an international crisis of terrifying magnitude.","release_date":"2000-05-24"},{"vote_count":7524,"id":284053,"video":false,"vote_average":7.5,"title":"Thor: Ragnarok","popularity":121.976,"poster_path":"/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg","original_language":"en","original_title":"Thor: Ragnarok","genre_ids":[28,12],"backdrop_path":"/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg","adult":false,"overview":"Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.","release_date":"2017-10-25"},{"vote_count":1475,"id":260513,"video":false,"vote_average":7.7,"title":"Incredibles 2","popularity":110.432,"poster_path":"/x1txcDXkcM65gl7w20PwYSxAYah.jpg","original_language":"en","original_title":"Incredibles 2","genre_ids":[28,12,16,10751],"backdrop_path":"/mabuNsGJgRuCTuGqjFkWe1xdu19.jpg","adult":false,"overview":"Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet \u2013 taking care of the problems of his three children.","release_date":"2018-06-14"},{"vote_count":3244,"id":333339,"video":false,"vote_average":7.7,"title":"Ready Player One","popularity":107.399,"poster_path":"/pU1ULUq8D3iRxl1fdX2lZIzdHuI.jpg","original_language":"en","original_title":"Ready Player One","genre_ids":[12,878,14],"backdrop_path":"/q7fXcrDPJcf6t3rzutaNwTzuKP1.jpg","adult":false,"overview":"When the creator of a popular video game system dies, a virtual contest is created to compete for his fortune.","release_date":"2018-03-28"},{"vote_count":432,"id":329263,"video":false,"vote_average":6.5,"title":"Suck Me Shakespeer 2","popularity":99.187,"poster_path":"/4jI6sIScJXMNyXxxloSfGqXckRj.jpg","original_language":"de","original_title":"Fack ju Göhte 2","genre_ids":[35],"backdrop_path":"/hzVZxS4lTXbVZ5emUPqtDYNm5Rz.jpg","adult":false,"overview":"Mr. Müller is not satisfied with his new work at the Goethe-Gesamtschule. The early getting up and correcting exams annoy him. Director Gerster wants to improve the image of the Goethe-Gesamtschule because she wants to be a symbol of the new company. To achieve this, she wants to take away the partnership from the Schillergymnasium with a Thai school. So, Mr. Müller, Mrs. Schnabelstedt and the 10b must go on a school trip to Thailand.","release_date":"2015-09-10"},{"vote_count":5387,"id":262500,"video":false,"vote_average":6.3,"title":"Insurgent","popularity":84.279,"poster_path":"/6w1VjTPTjTaA5oNvsAg0y4H6bou.jpg","original_language":"en","original_title":"Insurgent","genre_ids":[28,12,878,53],"backdrop_path":"/xOKGkKwfK79xjmBd1EiIbPpc71k.jpg","adult":false,"overview":"Beatrice Prior must confront her inner demons and continue her fight against a powerful alliance which threatens to tear her society apart.","release_date":"2015-03-18"},{"vote_count":2881,"id":238636,"video":false,"vote_average":6.6,"title":"The Purge: Anarchy","popularity":82.873,"poster_path":"/l1DRl40x2OWUoPP42v8fjKdS1Z3.jpg","original_language":"en","original_title":"The Purge: Anarchy","genre_ids":[27,53],"backdrop_path":"/zWGAnbxjjwY3xFGuOeR26LGbBlG.jpg","adult":false,"overview":"One night per year, the government sanctions a 12-hour period in which citizens can commit any crime they wish -- including murder -- without fear of punishment or imprisonment. Leo, a sergeant who lost his son, plans a vigilante mission of revenge during the mayhem. However, instead of a death-dealing avenger, he becomes the unexpected protector of four innocent strangers who desperately need his help if they are to survive the night.","release_date":"2014-07-17"},{"vote_count":49,"id":531949,"video":false,"vote_average":5.4,"title":"Father of the Year","popularity":75.048,"poster_path":"/mmBdCkZxHwQn5zM17cZmd3giJCY.jpg","original_language":"en","original_title":"Father of the Year","genre_ids":[35],"backdrop_path":"/ohqTNoA6pYzTXookp8UXNWQlAgY.jpg","adult":false,"overview":"Two college grads return to their hometown, where a hypothetical question -- whose dad would win in a fight? -- leads to mass mayhem.","release_date":"2018-07-20"},{"vote_count":394,"id":442249,"video":false,"vote_average":6.2,"title":"The First Purge","popularity":74.848,"poster_path":"/2slvblTroiT1lY9bYLK7Amigo1k.jpg","original_language":"en","original_title":"The First Purge","genre_ids":[28,27,878,53],"backdrop_path":"/dnaitaoCh8MftfYEVnprcuYExZp.jpg","adult":false,"overview":"To push the crime rate below one percent for the rest of the year, the New Founding Fathers of America test a sociological theory that vents aggression for one night in one isolated community. But when the violence of oppressors meets the rage of the others, the contagion will explode from the trial-city borders and spread across the nation.","release_date":"2018-07-04"},{"vote_count":2441,"id":447332,"video":false,"vote_average":7.2,"title":"A Quiet Place","popularity":74.549,"poster_path":"/nAU74GmpUk7t5iklEp3bufwDq4n.jpg","original_language":"en","original_title":"A Quiet Place","genre_ids":[18,27,53,878],"backdrop_path":"/tZmr0ozxSc2GasRuddtlRkf7f68.jpg","adult":false,"overview":"A family is forced to live in silence while hiding from creatures that hunt by sound.","release_date":"2018-04-03"}]
     */

    private int page;
    private int total_results;
    private int total_pages;
    private List<ResultsBean> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * vote_count : 273
         * id : 353081
         * video : false
         * vote_average : 7.5
         * title : Mission: Impossible - Fallout
         * popularity : 456.906
         * poster_path : /AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg
         * original_language : en
         * original_title : Mission: Impossible - Fallout
         * genre_ids : [12,28,53]
         * backdrop_path : /5qxePyMYDisLe8rJiBYX8HKEyv2.jpg
         * adult : false
         * overview : When an IMF mission ends badly, the world is faced with dire consequences. As Ethan Hunt takes it upon himself to fulfil his original briefing, the CIA begin to question his loyalty and his motives. The IMF team find themselves in a race against time, hunted by assassins while trying to prevent a global catastrophe.
         * release_date : 2018-07-25
         */

        private int vote_count;
        private int id;
        private boolean video;
        private double vote_average;
        private String title;
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;
        private String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
         //   return poster_path;
            return TMDB_IMAGE_PATH + poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
