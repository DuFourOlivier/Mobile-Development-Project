package com.example.mobile_dev_project;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Database(entities = {Word.class}, version = 1,exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    public static enum  Categoriën{Toerisme,Horeca,Nieuws,Feesten}
    public abstract WordDao wordDao();
    private static WordRoomDatabase INSTANCE;

     static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // database creation
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;



        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            List<Word> woordjes = new ArrayList<Word>();

            woordjes.add(new Word("De lokale politie van Antwerpen heeft zaterdag opnieuw verschillende lockdownfeestjes moeten stilleggen. De afgelopen week ging het op dat vlak al verscheidene malen mis. Deze keer ging het om maar liefst 3 bijeenkomsten van onverantwoordelijke feestvierders. Verschillende mensen zijn beboet of gearresteerd. Burgemeester Bart De Wever looft de politie om haar volhardende werk. “De resultaten van afgelopen nacht tonen hoe kordaat onze politiemensen blijven werken op het doen naleven van de coronamaatregelen.”","Antwerpse politie legt drie lockdownfeestjes stil (waarvan eentje zelfs twee keer)",Integer.toString(R.drawable.artikel1), Categoriën.Nieuws.toString()));
            woordjes.add(new Word("De internationale actiegroep ROSA protesteerde zaterdag in Brussel en verschillende Vlaamse steden tegen geweld tegen vrouwen. Rond 14 uur zaterdagmiddag passeerde het gezelschap de Groenplaats in Antwerpen. De acties stonden in het teken van de internationale dag tegen geweld op vrouwen afgelopen woensdag.","Actievoerders tegen geweld op vrouwen bezetten Groenplaats: “Ongepast gedrag op straat blijft alomtegenwoordig”",Integer.toString(R.drawable.artikel2), Categoriën.Nieuws.toString()));
            woordjes.add(new Word("‘Neffe A’: stoofvlees voor het goede doel. De Antwerpse restaurants La Pipe d’Anvers, Bacchus, Ciro’s, Spookkeuken Eat Casper en De Sinjoor doneren één portie stoofvlees per tien bestellingen via take-out aan daklozencentrum De Steenhouwer. “Met kerstavond worden de porties stoofvlees uitgedeeld aan de daklozen.”","Antwerpse restaurants doneren stoofvlees aan daklozen: “Wij worden altijd melig rond de kerstdagen”",Integer.toString(R.drawable.artikel3),Categoriën.Nieuws.toString()));
            woordjes.add(new Word("Nr. 16 van 162 dingen om te doen in Antwerpen\n" + "Bezienswaardigheden & bijzondere plaatsen, Historische wandelgebieden","Grote Markt",Integer.toString(R.drawable.artikel4),Categoriën.Toerisme.toString()));
            woordjes.add(new Word("Nr. 30 van 162 dingen om te doen in Antwerpen\n" + "Bezienswaardigheden & bijzondere plaatsen, Historische wandelgebieden, Pieren & boulevards","Antwerp's Port",Integer.toString(R.drawable.artikel5),Categoriën.Toerisme.toString()));
            woordjes.add(new Word("Nr. 36 van 162 dingen om te doen in Antwerpen\n" + "Bezienswaardigheden & bijzondere plaatsen","Groenplaats",Integer.toString(R.drawable.artikel6),Categoriën.Toerisme.toString()));
            woordjes.add(new Word("Informatie over Manhattns:" +
                    "\n" +
                    "\n" +
                    "Adres: Groenplaats 1, 2000 Antwerpen\n" +
                    "\n"+
                    "Openingstijden: \n" +
                    "\n" +
                    "maandag\t11:30–22:30\n" +
                    "dinsdag\t11:30–22:30\n" +
                    "woensdag\t11:30–22:30\n" +
                    "donderdag\n" +
                    "(Kerstavond)\n" +
                    "Gesloten\n" +
                    "Afwijkende openingstijden\n" +
                    "vrijdag\n" +
                    "(Kerstmis)\n" +
                    "Gesloten\n" +
                    "Afwijkende openingstijden\n" +
                    "zaterdag\t11:30–22:30\n" +
                    "zondag\t11:30–22:30\n" +
                    "Bewerking voorstellen\n" +
                    "\n" +
                    "Telefoon: 03 434 54 53\n" +
                    "\n" +
                    "Bestellen: deliveroo.be","Manhattns",Integer.toString(R.drawable.artikel7),Categoriën.Horeca.toString()));
            woordjes.add(new Word("Informatie over Dagiovanni:" + "\n" +
                    "\n" +
                    "Adres: Jan Blomstraat 8, 2000 Antwerpen\n" +
                    "\n" +
                    "Openingstijden: \n" +
                    "maandag\t11:00–14:30, 17:00–22:00\n" +
                    "dinsdag\t11:00–14:30, 17:00–22:00\n" +
                    "woensdag\t11:00–14:30, 17:00–22:00\n" +
                    "donderdag\n" +
                    "(Kerstavond)\n" +
                    "11:00–14:30, 17:00–22:00\n" +
                    "Openingstijden kunnen afwijken\n" +
                    "vrijdag\n" +
                    "(Kerstmis)\n" +
                    "11:00–14:30, 17:00–22:00\n" +
                    "Openingstijden kunnen afwijken\n" +
                    "zaterdag\t11:00–14:30, 17:00–21:30\n" +
                    "zondag\t11:00–14:30, 17:00–21:30\n" +
                    "\n" +
                    "Telefoon: 03 225 00 96","Dagiovanni",Integer.toString(R.drawable.artikel8),Categoriën.Horeca.toString()));
            woordjes.add(new Word("Informatie over Hardrockcafe:" +
                    "\n" +
                    "\n" +
                    "Adres: Groenplaats 35, 2000 Antwerpen\n" +
                    "\n" +
                    "Openingstijden:" +
                    "maandag\t12:00–21:30\n" +
                    "dinsdag\t12:00–21:30\n" +
                    "woensdag\t12:00–21:30\n" +
                    "donderdag\n" +
                    "(Kerstavond)\n" +
                    "12:00–21:30\n" +
                    "Openingstijden kunnen afwijken\n" +
                    "vrijdag\n" +
                    "(Kerstmis)\n" +
                    "12:00–21:30\n" +
                    "Openingstijden kunnen afwijken\n" +
                    "zaterdag\t12:00–21:30\n" +
                    "zondag\t12:00–21:30\n"+
                    "\n" +
                    "Telefoon: 03 205 13 80","Hardrockcafe ",Integer.toString(R.drawable.artikel9),Categoriën.Horeca.toString()));
            woordjes.add(new Word("Informatie:" +
                    "\n" +
                    "\n" +
                    "Datum: zaterdag 27 februari 2021\n" +
                    "\n" +
                    "Uur: 23:00 - 07:00" +
                    "\n" +
                    "\n" +
                    "Minimumleeftijd: 18" +
                    "\n" +
                    "\n" +
                    "Genre: house, techno, electro, tekno, disco" +
                    "\n" +
                    "\n" +
                    "Line-up Ampere:\n" +
                    "\n" +
                    "Live: Borokov Borokov\n" +
                    "David Vunk Nederland house, techno\n" +
                    "Opium Hum Duitsland","Borokov Borokov & David Vunk & Opium Hum | Ampere",Integer.toString(R.drawable.artikel10),Categoriën.Feesten.toString()));
            woordjes.add(new Word(
                    "Informatie:" +
                    "\n" +
                    "\n" +
                    "Datum: vrijdag 9 april 2021\n" +
                    "\n" +
                    "\n" +
                    "Tickets & prijzen Club Vaag Invites" +
                            "\n" +
                            "\n" +
                    "Voorverkoop 1:	€ 	10	,"+
                            "\n" +
                    "Voorverkoop 2:	€ 	12	,"+
                            "\n" +
                    "Deurverkoop:	€ 	15	,-"+
                            "\n" +
                            "\n" +
                    "Uur: 23:00 - 06:00" +
                    "\n" +
                    "\n" +
                    "Minimumleeftijd: 18" +
                    "\n" +
                    "\n" +
                    "Genre: house, techno, electro, tekno, disco" +
                    "\n" +
                    "\n" +
                    "Line-up Club Vaag:\n" +
                    "\n" +
                    "Gary Beck Schotland techno\n" +
                            "Himperson house, techno\n" +
                            "Ramon Tapia Nederland → België techno","Club Vaag invites Gary Beck / Ramon Tapia",Integer.toString(R.drawable.artikel11),Categoriën.Feesten.toString()));
            woordjes.add(new Word(                    "Informatie:" +
                    "\n" +
                    "\n" +
                    "Datum: zaterdag 5 december 2020\n" +
                    "\n" +
                    "\n" +
                    "Tickets & prijzen Club Vaag Invites" +
                    "\n" +
                    "\n" +
                    "Voorverkoop: \t€ \t61\t,-\t4 personen,"+
                    "\n" +
                    "Voorverkoop: € \t76\t,-\t5 personen,"+
                    "\n" +
                    "Deurverkoop:\t€ \t91\t,-\t6 personen\n"+
                    "\n" +
                    "\n" +
                    "Uur: 17:00 - 23:00" +
                    "\n" +
                    "\n" +
                    "Minimumleeftijd: 18" +
                    "\n" +
                    "\n" +
                    "Genre: techno, techhouse, trance, progressive trance, classics" +
                    "\n" +
                    "\n" +
                    "Line-up Café Vaag:\n" +
                    "\n" +
                    "Himperson house, techno\n" +
                    "Patrice Van Delm techno\n" +
                    "Yves Deruyter techno, trance, house, retro","Comme Chez Vaag invites Yves Deruyter",Integer.toString(R.drawable.artikel12),Categoriën.Feesten.toString()));

            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            mDao.deleteAll();

            for (int i = 0; i <= woordjes.size() - 1; i++) {
                mDao.insert(woordjes.get(i));
            }
            return null;
        }
    }

}
