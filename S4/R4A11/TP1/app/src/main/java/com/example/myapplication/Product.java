package com.example.myapplication;

public class Product {
    private String name;
    private String codeProduct;
    public Product(String name ){
        this.name = name;
        this.initCodeProduct();
    }

    public String getName() { return name; }

    private void initCodeProduct() {
        switch (name.toLowerCase()) {
            case "margherita":
                codeProduct = "01";
                break;
            case "savoyarde":
                codeProduct = "02";
                break;
            case "reine":
                codeProduct = "03";
                break;
            case "calzone":
                codeProduct = "04";
                break;
            case "royale":
                codeProduct = "05";
                break;
            case "hawaïenne":
                codeProduct = "06";
                break;
            case "sicilienne":
                codeProduct = "07";
                break;
            case "marinara":
                codeProduct = "08";
                break;
            case "capricciosa":
                codeProduct = "09";
                break;
            case "quatre saisons":
                codeProduct = "10";
                break;
            case "napolitaine":
                codeProduct = "11";
                break;
            case "diavola":
                codeProduct = "12";
                break;
            case "romaine":
                codeProduct = "13";
                break;
            case "quatre fromages":
                codeProduct = "14";
                break;
            case "salami":
                codeProduct = "15";
                break;
            case "chèvre miel":
                codeProduct = "16";
                break;
            case "fuggazzeta":
                codeProduct = "17";
                break;
            case "montagnarde":
                codeProduct = "18";
                break;
            case "focaccia à l'ail":
                codeProduct = "19";
                break;
            case "raclette":
                codeProduct = "20";
                break;
            case "saumon fumé":
                codeProduct = "21";
                break;
            case "tiramisu":
                codeProduct = "91";
                break;
            case "amaretti":
                codeProduct = "92";
                break;
            case "glace":
                codeProduct = "93";
                break;
            case "panna cotta":
                codeProduct = "94";
                break;
            case "pain perdu":
                codeProduct = "95";
                break;
            case "crêpe":
                codeProduct = "96";
                break;
            case "crème brûlée":
                codeProduct = "97";
                break;
            case "tarte aux pommes":
                codeProduct = "98";
                break;
            case "mousse au chocolat":
                codeProduct = "99";
                break;
            default:
                codeProduct = "00"; // Code par défaut si le produit n'est pas trouvé
                break;
        }
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }
}
