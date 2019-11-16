import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Unify {
    public static ArrayList<String> Leer(String Ubicacion) throws IOException{
        BufferedReader br = null;
        ArrayList<String> conjunto = new ArrayList<>();
        try {
            br =new BufferedReader(new FileReader(Ubicacion));
            String line = br.readLine();
            while (null!=line) {
                conjunto.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {if (null!=br) {br.close();}}
        Organizar(conjunto);
        return conjunto;
    }
    public static ArrayList<ArrayList<String>> Organizar(ArrayList Args){
        ArrayList<ArrayList<String>> Operaciones = new ArrayList<>();
        String reglas="";
        Operaciones.add(new ArrayList<>());
        Operaciones.add(new ArrayList<>());
        for(int i=0;i<Args.size();i++){
            reglas=(String) Args.get(i);
            for(int j=0;j<reglas.length();j++){
                if(reglas.substring(j, j+1).equals("=")){
                    Operaciones.get(0).add(reglas.substring(0, j));
                    Operaciones.get(1).add(reglas.substring(j+1, reglas.length()));
                }
            }
        }
        return Operaciones;
    }
    public static ArrayList<Boolean> Comparar(ArrayList<ArrayList<String>> separados){
        ArrayList<Boolean> comparar = new ArrayList<>();
        for(int i=0;i<separados.get(0).size();i++){
            if(separados.get(0).get(i).equals(separados.get(1).get(i))){
                comparar.add(true);
            }else{
                comparar.add(false);
            }
        }
        for(int i=0;i<comparar.size();i++){
            if(comparar.get(i).equals(true)){
                System.out.println(separados.get(i)+" Si se puede unificar");
            }else if(comparar.get(i).equals(false)){
                System.out.println(separados.get(i)+" No se puede unificar");
            }
        }
        return comparar;
    }

}
