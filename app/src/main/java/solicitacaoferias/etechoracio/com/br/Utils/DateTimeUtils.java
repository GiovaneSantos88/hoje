package solicitacaoferias.etechoracio.com.br.Utils;

import android.widget.Button;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import solicitacaoferias.etechoracio.com.br.SolicitacaoActivity;

public class DateTimeUtils {

    public static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static Date toDate(String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean isSegundaFeira(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        if (dia == 2){
            return true;
        }else{
            return dia == 2;
        }

    }

    public static String formatDate(int dia, int mes, int ano) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(ano, mes, dia);
            return DATE_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            return null;

        }
    }

    public static Date calcularDataFinal(Date data, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, dias);
        return calendar.getTime();
    }


    // public  static Date toDate (String date){
    //try {
    //  return DATE_FORMAT.parse(date);
    // } catch (ParseException e) {

    //     return null;
    //  }
    //  }
}



