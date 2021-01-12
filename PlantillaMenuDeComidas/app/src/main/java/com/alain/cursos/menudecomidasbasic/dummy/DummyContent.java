package com.alain.cursos.menudecomidasbasic.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
 * Firebase for Android
 * Created by Alain Nicolás Tello on 01/04/2020 at 01:16pm
 * All rights reserved 2020.
 * Course Specialize in Firebase for Android with MVP 2018-2020
 * More info: https://www.udemy.com/especialidad-en-firebase-para-android-con-mvp-profesional/
 */

/**
 * Helper class for providing sample name for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Comida> ITEMS = new ArrayList<Comida>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Comida> ITEM_MAP = new HashMap<String, Comida>();

    // set to 0
    private static final int COUNT = 0;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Comida item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Comida createDummyItem(int position) {
        return new Comida(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of name.
     */
    // Re-create class COMIDA
    public static class Comida {
        private String id;
        // renombramos los atributos correspondientes...
        private String name;
        private String price;

        // firebase requiere que nuestra clase tenga un constructor vacio
        public Comida() {
        }

        public Comida(String id, String name, String price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        //métodos getter y setter
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        // equals and hasCode unicamente con el ID
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Comida comida = (Comida) o;

            return id != null ? id.equals(comida.id) : comida.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
