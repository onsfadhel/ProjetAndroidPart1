package com.example.projectandroid;
//cette classe va regrouper toutes les fcts qui seront dispo tout au long du prj
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
public class SharedHelper {
    public static String sha256(String s){
        try{
            //creation du hash sha256
            //algorithme de résumé de message (fct de hachage unidirectionnels sécurisé )
            MessageDigest digest=java.security.MessageDigest.getInstance("SHA256");
            //méthode pour terminer le calcul de hachage
            //update: met àjour le résumé à l'aide d'un tableau d'octect spécifié
            digest.update(s.getBytes());
            byte messageDigest[]=digest.digest();
            //creation du chaine en hexa
            StringBuffer hexString=new StringBuffer();
            //convertir les nbre - en ++
            for (int i=0;i<messageDigest.length;i++){
                hexString.append(Integer.toHexString(messageDigest[i]& 0xFF));
            }
            return  hexString.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
