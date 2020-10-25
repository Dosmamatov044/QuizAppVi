package com.example.quizappvi.ui.fragments.settings;

public class ThemeModel {
    private int color;
    private boolean isItCheckout;

    public ThemeModel(int color, boolean isItCheckout) {
        this.color = color;
        this.isItCheckout = isItCheckout;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isItCheckout() {
        return isItCheckout;
    }

    public void setItCheckout(boolean itCheckout) {
        isItCheckout = itCheckout;
    }
}
