package teoriaprimos;
public class NumerosPrimos {
    private int suma_ascii;
    private boolean primo;

    public void setCadena_calculo(int cadena_calculo) {
        this.suma_ascii = cadena_calculo;
    }

    public boolean is_primo() {
        primo = true;
        int residuo;
        //Inicio en el segundo primo, todos son divisibles exactos entre 1 y entre el ultimo
        for(int i=2;i < suma_ascii;i++)
	{
           residuo = suma_ascii%i;
           //Si un residuo es dif. de cero ya no es primo
	   if(residuo==0)
	   {
	      primo=false;
	      break;
	   }
	}
        return primo;
    }
    
}