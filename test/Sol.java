package com.company.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Sol {

    public static void main(String[] args) throws IOException {
        String[] arr = {
                "Afghanistan", "Ã…land Islands", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia",
                "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
                "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan",
                "Bolivia, Plurinational State of", "Bonaire, Sint Eustatius and Saba",
                "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil",
                "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso",
                "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
                "Central African Republic", "Chad", "Chile", "China", "Christmas Island",
                "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
                "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica"
        };
        for (String ct : arr) {
            getCapitalCity(ct.trim());
        }
        System.out.println(getCapitalCity("India"));

        getAllData();


    }


    public static void getAllData() {
        int page = 1;
        StringBuilder sb;

        try {
            while (page != 26) {
                sb = new StringBuilder();
                URL url = new URL(
                        "https://*.com/api/countries?page=" + page);

                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                con.setRequestMethod("GET");
                con.setRequestProperty("Accept", "application/json");

                con.setDoOutput(true);

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));

                String response = null;
                while ((response = br.readLine()) != null) {
                    sb.append(response.trim());
                }
                System.out.println(sb);
                page++;
            }

        } catch (MalformedURLException e) {
            System.out.println("Wrong Url ");
        } catch (ProtocolException e) {
            System.out.println("Wrong Protocol ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getCapitalCity(String country) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL("https://*.com/api/countries?name=" + country);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(true);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {

            String response = null;
            while ((response = br.readLine()) != null) {
                sb.append(response.trim());
            }
            System.out.println(sb);
            JSONObject object = new JSONObject(sb.toString());

            JSONArray array = object.getJSONArray("data");

            JSONObject ct = array.getJSONObject(0);
            if (ct.has(("capital"))) {
                return ct.getString("capital");
            }

        } catch (IOException e) {
            System.out.println("[-] Unknown Country " + country);
        } catch (JSONException e) {
            System.out.println("[-] JSON error in Country " + country);
            System.out.println(sb);
        }
        return "-1";
    }

}
