package ru.artsok.dao.entitys;


public class Productions {
    private String nameProduction;
    private String mainImage;
    private String mainText;
    private String firstImage;
    private String secondImage;
    private String thirdImage;
    private String description;
    private String newLine;

    public Productions(String mainImage, String mainText, String nameProduction, String description, String firstImage, String secondImage, String thirdImage, String newLine) {
        this.description = description;
        this.firstImage = firstImage;
        this.mainImage = mainImage;
        this.mainText = mainText;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.nameProduction = nameProduction;
        this.newLine = newLine;
    }

    public Productions(){}

    public Productions(ProductionsBuilder builder) {
        this.description = builder.description;
        this.firstImage = builder.firstImage;
        this.mainImage = builder.mainImage;
        this.mainText = builder.mainText;
        this.secondImage = builder.secondImage;
        this.thirdImage = builder.thirdImage;
        this.nameProduction = builder.buttonName;
        this.newLine = builder.newLine;
    }

    public String getDescription() {
        return description;
    }


    public String getFirstImage() {
        return firstImage;
    }


    public String getMainImage() {
        return mainImage;
    }


    public String getMainText() {
        return mainText;
    }


    public String getSecondImage() {
        return secondImage;
    }


    public String getThirdImage() {
        return thirdImage;
    }


    public String getNameProduction() {
        return nameProduction;
    }


    public String getNewLine() {
        return newLine;
    }

    public static class ProductionsBuilder {
        private String buttonName;
        private String mainImage;
        private String mainText;
        private String firstImage;
        private String secondImage;
        private String thirdImage;
        private String description;
        private String newLine;

        public ProductionsBuilder buttonName(String buttonName) {
            this.buttonName = buttonName;
            return this;
        }

        public ProductionsBuilder mainImage(String mainImage) {
            this.mainImage = mainImage;
            return this;
        }

        public ProductionsBuilder mainText(String mainText) {
            this.mainText = mainText;
            return this;
        }

        public ProductionsBuilder firstImage(String firstImage) {
            this.firstImage = firstImage;
            return this;
        }

        public ProductionsBuilder secondImage(String secondImage) {
            this.secondImage = secondImage;
            return this;
        }

        public ProductionsBuilder thirdImage(String thirdImage) {
            this.thirdImage = thirdImage;
            return this;
        }

        public ProductionsBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductionsBuilder newLine(String newLine) {
            this.newLine = newLine;
            return this;
        }

        public Productions build(){
            return new Productions(this);
        }
    }
}
