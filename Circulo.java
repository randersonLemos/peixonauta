package org.Circulo;

//Sobrecarga de método
public class Circulo {
	int centroX, centroY, raio;
	
    public void define(int centroX, int centroY, int raio){
        this.centroX = centroX;
        this.centroY = centroY;
        this.raio = raio;
    }

    public void define(String parametros){
        String array[] = new String[3];
        array = parametros.split(";");
        this.define(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
    }
    
    public double area(){
        double area = Math.PI*(raio*raio);
        return area;
    }
    
    public static void main(String args[]) {
    	Circulo circ = new Circulo();
    	Circulo circ2 = new Circulo();
    	
    	circ.define(1,2,1);
    	circ2.define("2;3;2");

    	System.out.println("centroX = " + circ.centroX);
    	System.out.println("centroY = " + circ.centroY);
    	System.out.println("raio = " + circ.raio);

    	System.out.println("centroX = " + circ2.centroX);
    	System.out.println("centroY = " + circ2.centroY);
    	System.out.println("raio = " + circ2.raio);	
	}
}
