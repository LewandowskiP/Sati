/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionManagement;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Przemysław
 */
public class Global {

    static DataBaseConnector dbc;

    static Employee employee;

    public static DataBaseConnector getDataBaseConnector() {
        if (dbc == null) {
            dbc = new DataBaseConnector();
        }
        return dbc;
    }
    public static final int MINUTES_TO = 480;
    public static final int NOONE = -1;
    public static final int CEO = 1;
    public static final int STOREMAN = 2;
    public static final int OPERATOR = 3;
    public static final int HALL_MANAGER = 4;
    public static final int LAB_ASSISTANT = 5;
    public static final int OFFICE = 6;
    public static final int ADMINISTRATOR = 999;

    public static final int COFFEE_GREEN_TO_EXAMINE = 1;
    public static final int COFFEE_GREEN_NOT_ACCEPTED = 2;
    public static final int COFFEE_GREEN_TO_STORE = 3;
    public static final int COFFEE_GREEN_READY_TO_ROAST = 4;
    public static final int COFFEE_GREEN_OUT_OF_STORE = 5;

    public static final int TO_EXAMINE = 1;
    public static final int NOT_ACCEPTED = 2;
    public static final int TO_STORE = 3;
    public static final int READY_TO_USE = 4;
    public static final int OUT_OF_STORE = 5;

    public static final int PRODUCTION_COFFEE_READY = 1;
    public static final int PRODUCTION_COFFEE_OUT_OF_STORE = 2;

    public static final int PRODUCTION_COFFEE_EXTERNAL_TO_EXAMINE = 1;
    public static final int PRODUCTION_COFFEE_EXTERNAL_NOT_ACCEPTED = 2;
    public static final int PRODUCTION_COFFEE_EXTERNAL_TO_STORE = 3;
    public static final int PRODUCTION_COFFEE_EXTERNAL_READY_TO_USE = 4;

    public static final int PRODUCTION_COFFEE_PARTIALLY_USED = 1;
    public static final int PRODUCTION_COFFEE_TOTALLY_USED = 2;
    public static final int PRODUCTION_COFFEE_NONE_USED = 3;

    public static final int PRODUCTION_LINE_TYPE_ROAST = 1;
    public static final int PRODUCTION_LINE_TYPE_PACKING = 2;

    public static final int PRODUCTION_RAPORT_OPEN = 1;
    public static final int PRODUCTION_RAPORT_CLOSED = 2;

    public static final int PRODUCT_ORDERED = 1;
    public static final int PRODUCT_ACCEPTED = 2;
    public static final int PRODUCT_COMPLETED = 3;
    public static final int PRODUCT_STORED = 4;

    public static final boolean FILE_READ_ONLY = false;
    public static final boolean FILE_WRITEABLE = true;

    public static final String PRODUCTION_COFFEE_USED = "ZUŻYTA";
    public static final String PRODUCTION_COFFEE_RETURNED = "ODDANA";
    public static final String PRODUCTION_COFFEE_NOT_USED = "NIE ZUŻYTA";

    public static final int PRODUCTION_RAPORT_PART_WAITING = 1;
    public static final int PRODUCTION_RAPORT_PART_BLOCKED = 2;
    public static final int PRODUCTION_RAPORT_PART_ACCEPTED = 3;
    public static final int PRODUCTION_RAPORT_PART_TO_STORE = 4;

    public static final int PRODUCTION_RAPORT_PART_STORED = 0;

    public static final int PRODUCT_TYPE_ROAST = 1;
    public static final int PRODUCT_TYPE_PACK = 2;

    public static final int PRODUCT_TYPE_BEAN = 0;
    public static final int PRODUCT_TYPE_GRIND = 1;
    public static final int PRODUCT_TYPE_INSTANT = 2;
    public static final int PRODUCT_TYPE_HALF = 3;

    public static final int RESOURCE_TYPE_COFFEE_GREEN = 0;
    public static final int RESOURCE_TYPE_COFFEE_INSTANT = 1;
    public static final int RESOURCE_TYPE_COFFEE_POWDER = 2;
    public static final int RESOURCE_TYPE_PACKAGE = 3;
    public static final int RESOURCE_TYPE_AROMA = 4;
    public static final int RESOURCE_TYPE_COFFEE_PADS = 5;
    public static final int RESOURCE_TYPE_COFFEE_RETURNED = 6;
    public static final int RESOURCE_TYPE_COFFEE_OTHER = 7;
    public static final int RESOURCE_TYPE_COFFEE_CAPSULE = 8;
    public static final int RESOURCE_TYPE_CARDBOARD = 9;

    public static final int PALLETE_WAITING = 1;
    public static final int PALLETE_CHECKED = 2;
    public static final int PALLETE_STORED = 3;

    public static final int MODE_PRINT_DELETE = 1;
    public static final int MODE_ALL = 2;

    public static final boolean YES = true;
    public static final boolean NO = false;

    public static final String qtinID = "01";
    public static final String qtinText = "EAN13: ";

    public static final String prodDateID = "11";
    public static final String prodDateText = "Production date: ";
    public static final String expiryDateID = "15";
    public static final String expiryDateText = "Expiration date: ";
    public static final String lotID = "10";
    public static final String lotText = "Lot: ";
    public static final String quantityID = "30";
    public static final String quantityText = "Quantity: ";
    public static final String nettoID = "3102";
    public static final String nettoText = "Netto weight: ";
    public static final String productNameText = "Product name: ";
    public static final String palleteNumberText = "Pallete number:  ";
    public static final String employeeCodeText = "Operator code:  ";
    public static String palleteNumberID = "91";

    public static final String ean128TemplateLot = "(01)n13+cd(10)an1-19(15)n6";
    public static final String ean128TemplatePallete = "(11)n6(3102)n6(30)n8";
    public static final String ean128TemplateNum = "(91)an1-30";
    public static final int labelOffset = 20;
    public static final char eanSeparator = '*';
    public static final int dpiResolution = 72;
    public static final int labelEanDpi = dpiResolution * 4;
    public static final int labelFontSize = 14;

    public static final int a4CanvasSizeWidth = 1754;
    public static final int a4CanvasSizeHeight = 1240;

    public static final float a4PrintOffset = 0.2f;

    public static final float a4xDimInches = 11.7f;
    public static final float a4yDimInches = 8.3f;

    public static final float a4xDimPixels = a4xDimInches * dpiResolution;
    public static final float a4yDimPixels = a4yDimInches * dpiResolution;

    public static String getProductTypeName(int type) {
        if (type == PRODUCT_TYPE_BEAN) {
            return "Ziarno";
        } else if (type == PRODUCT_TYPE_GRIND) {
            return "Mielona";
        } else if (type == PRODUCT_TYPE_INSTANT) {
            return "Instant";
        } else if (type == PRODUCT_TYPE_HALF) {
            return "Półprodukt";
        }
        return "BŁAD";
    }

    public static String timestampToStrDDMMYYYY(Timestamp ts) {
        String date = String.valueOf(ts.getDate());
        date += "-" + String.valueOf(ts.getMonth() + 1);
        date += "-" + String.valueOf(ts.getYear() + 1900);
        return date;
    }

    public static String timestampToStrYYMMDD(Timestamp ts) {
        String date = String.format("%02d", (ts.getYear() + 1900) % 100);
        date += String.format("%02d", ts.getMonth() + 1);
        date += String.format("%02d", ts.getDate());
        return date;
    }

    public static Employee getEmployee() {
        return employee;
    }

    public static void setEmployee(Employee employee) {
        Global.employee = employee;
    }

    public static String getProductStateState(int i) {
        String retString;
        switch (i) {
            case 1: {
                retString = "2 - Badanie";
                break;
            }
            case 2: {
                retString = "1 - Zablokowany";
                break;
            }

            case 3: {
                retString = "3 - Zatwierdzanie";
                break;
            }

            case 4: {
                retString = "4 - Magazynowanie";
                break;
            }

            case 5: {
                retString = "Zmagazynowano";
                break;
            }

            default:
                retString = "Błąd";
        }
        return retString;

    }

    public static String getPalleteState(int i) {
        String retString;
        switch (i) {
            case 1: {
                retString = "1 - Oczekiwanie";
                break;
            }
            case 2: {
                retString = "2 - Zatawierdzony";
                break;
            }

            case 3: {
                retString = "3 - Zmagazynowane";
                break;
            }
            default:
                retString = "Błąd";
        }
        return retString;

    }

    public static int currentShift() {
        int shift = 0;
        Date now = new Timestamp(System.currentTimeMillis());
        int hour = now.getHours();

        if ((hour >= 22 && hour <= 24) || (hour >= 0 && hour < 6)) {
            shift = 3;
        }
        if (hour >= 14 && hour < 22) {
            shift = 2;
        }
        if (hour >= 6 && hour < 14) {
            shift = 1;
        }
        return shift;
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_DOWN);
        return bd.floatValue();
    }
}
