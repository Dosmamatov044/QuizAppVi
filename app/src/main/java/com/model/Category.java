package com.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("General Knowledge")
    private String  General_Knowledge;
    @SerializedName("Entertainment: Books")
    private String Entertainment_Books;
    @SerializedName("Entertainment: Film")
    private String Entertainment_Film;
    @SerializedName("Entertainment: Music")
    private String Entertainment_Music;
    @SerializedName("Entertainment: Musicals & Theatres")
    private String Entertainment_Musicals_Theatres;
    @SerializedName("Entertainment: Television")
    private String Entertainment_Television;
    @SerializedName("Entertainment: Video Games")
    private String Entertainment_Video_Games;
    @SerializedName("Entertainment: Board Games")
    private String Entertainment_Board_Games;
    @SerializedName("Science & Nature")
    private String Science_Nature;
    @SerializedName("Science: Computers")
    private String Science_Computers;
    @SerializedName("Science: Mathematics")
    private String Science_Mathematics;
    @SerializedName("Mythology")
    private String Mythology;
    @SerializedName("Sports")
    private String Sports;
    @SerializedName("Geography")
    private String Geography;
    @SerializedName("History")
    private String History;
    @SerializedName("Politics")
    private String Politics;

    private String Art;

    private String Celebrities;

    private String Animals;

    private String Vehicles;
    @SerializedName("Entertainment: Comics")
    private String Entertainment_Comics;
    @SerializedName("Science: Gadgets")
    private String Science_Gadgets;
    @SerializedName("Entertainment: Japanese Anime & Manga")
    private String Entertainment_Japanese_Anime_Manga;
    @SerializedName("Entertainment: Cartoon & Animations")
    private String Entertainment_Cartoon_Animations;


    public Category(String general_Knowledge, String entertainment_Books, String entertainment_Film, String entertainment_Music, String entertainment_Musicals_Theatres, String entertainment_Television, String entertainment_Video_Games, String entertainment_Board_Games, String science_Nature, String science_Computers, String science_Mathematics, String mythology, String sports, String geography, String history, String politics, String art, String celebrities, String animals, String vehicles, String entertainment_Comics, String science_Gadgets,
                    String entertainment_Japanese_Anime_Manga, String entertainment_Cartoon_Animations) {
        General_Knowledge = general_Knowledge;
        Entertainment_Books = entertainment_Books;
        Entertainment_Film = entertainment_Film;
        Entertainment_Music = entertainment_Music;
        Entertainment_Musicals_Theatres = entertainment_Musicals_Theatres;
        Entertainment_Television = entertainment_Television;
        Entertainment_Video_Games = entertainment_Video_Games;
        Entertainment_Board_Games = entertainment_Board_Games;
        Science_Nature = science_Nature;
        Science_Computers = science_Computers;
        Science_Mathematics = science_Mathematics;
        Mythology = mythology;
        Sports = sports;
        Geography = geography;
        History = history;
        Politics = politics;
        Art = art;
        Celebrities = celebrities;
        Animals = animals;
        Vehicles = vehicles;
        Entertainment_Comics = entertainment_Comics;
        Science_Gadgets = science_Gadgets;
        Entertainment_Japanese_Anime_Manga = entertainment_Japanese_Anime_Manga;
        Entertainment_Cartoon_Animations = entertainment_Cartoon_Animations;
    }

    public Category() {
    }


    public String getGeneral_Knowledge() {
        return General_Knowledge;
    }

    public void setGeneral_Knowledge(String general_Knowledge) {
        General_Knowledge = general_Knowledge;
    }

    public String getEntertainment_Books() {
        return Entertainment_Books;
    }

    public void setEntertainment_Books(String entertainment_Books) {
        Entertainment_Books = entertainment_Books;
    }

    public String getEntertainment_Film() {
        return Entertainment_Film;
    }

    public void setEntertainment_Film(String entertainment_Film) {
        Entertainment_Film = entertainment_Film;
    }

    public String getEntertainment_Music() {
        return Entertainment_Music;
    }

    public void setEntertainment_Music(String entertainment_Music) {
        Entertainment_Music = entertainment_Music;
    }

    public String getEntertainment_Musicals_Theatres() {
        return Entertainment_Musicals_Theatres;
    }

    public void setEntertainment_Musicals_Theatres(String entertainment_Musicals_Theatres) {
        Entertainment_Musicals_Theatres = entertainment_Musicals_Theatres;
    }

    public String getEntertainment_Television() {
        return Entertainment_Television;
    }

    public void setEntertainment_Television(String entertainment_Television) {
        Entertainment_Television = entertainment_Television;
    }

    public String getEntertainment_Video_Games() {
        return Entertainment_Video_Games;
    }

    public void setEntertainment_Video_Games(String entertainment_Video_Games) {
        Entertainment_Video_Games = entertainment_Video_Games;
    }

    public String getEntertainment_Board_Games() {
        return Entertainment_Board_Games;
    }

    public void setEntertainment_Board_Games(String entertainment_Board_Games) {
        Entertainment_Board_Games = entertainment_Board_Games;
    }

    public String getScience_Nature() {
        return Science_Nature;
    }

    public void setScience_Nature(String science_Nature) {
        Science_Nature = science_Nature;
    }

    public String getScience_Computers() {
        return Science_Computers;
    }

    public void setScience_Computers(String science_Computers) {
        Science_Computers = science_Computers;
    }

    public String getScience_Mathematics() {
        return Science_Mathematics;
    }

    public void setScience_Mathematics(String science_Mathematics) {
        Science_Mathematics = science_Mathematics;
    }

    public String getMythology() {
        return Mythology;
    }

    public void setMythology(String mythology) {
        Mythology = mythology;
    }

    public String getSports() {
        return Sports;
    }

    public void setSports(String sports) {
        Sports = sports;
    }

    public String getGeography() {
        return Geography;
    }

    public void setGeography(String geography) {
        Geography = geography;
    }

    public String getHistory() {
        return History;
    }

    public void setHistory(String history) {
        History = history;
    }

    public String getPolitics() {
        return Politics;
    }

    public void setPolitics(String politics) {
        Politics = politics;
    }

    public String getArt() {
        return Art;
    }

    public void setArt(String art) {
        Art = art;
    }

    public String getCelebrities() {
        return Celebrities;
    }

    public void setCelebrities(String celebrities) {
        Celebrities = celebrities;
    }

    public String getAnimals() {
        return Animals;
    }

    public void setAnimals(String animals) {
        Animals = animals;
    }

    public String getVehicles() {
        return Vehicles;
    }

    public void setVehicles(String vehicles) {
        Vehicles = vehicles;
    }

    public String getEntertainment_Comics() {
        return Entertainment_Comics;
    }

    public void setEntertainment_Comics(String entertainment_Comics) {
        Entertainment_Comics = entertainment_Comics;
    }

    public String getScience_Gadgets() {
        return Science_Gadgets;
    }

    public void setScience_Gadgets(String science_Gadgets) {
        Science_Gadgets = science_Gadgets;
    }

    public String getEntertainment_Japanese_Anime_Manga() {
        return Entertainment_Japanese_Anime_Manga;
    }

    public void setEntertainment_Japanese_Anime_Manga(String entertainment_Japanese_Anime_Manga) {
        Entertainment_Japanese_Anime_Manga = entertainment_Japanese_Anime_Manga;
    }

    public String getEntertainment_Cartoon_Animations() {
        return Entertainment_Cartoon_Animations;
    }

    public void setEntertainment_Cartoon_Animations(String entertainment_Cartoon_Animations) {
        Entertainment_Cartoon_Animations = entertainment_Cartoon_Animations;
    }
}
