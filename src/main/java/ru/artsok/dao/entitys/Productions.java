package ru.artsok.dao.entitys;


public class Productions {
    private String buttonName;
    private String mainImage;
    private String mainText;
    private String firstImage;
    private String secondImage;
    private String thirdImage;
    private String description;
    private String newLine;

    public Productions(String mainImage, String mainText, String buttonName, String description, String firstImage, String secondImage, String thirdImage, String newLine) {
        this.description = description;
        this.firstImage = firstImage;
        this.mainImage = mainImage;
        this.mainText = mainText;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.buttonName = buttonName;
        this.newLine = newLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(String secondImage) {
        this.secondImage = secondImage;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public void setThirdImage(String thirdImage) {
        this.thirdImage = thirdImage;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getNewLine() {
        return newLine;
    }

    public void setNewLine(String newLine) {
        this.newLine = newLine;
    }
}
