package uno.poo1.getPersonas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*

1. Implementar un método estático getPersonas que reciba el nombre de un archivo 
y devuelva un objeto LinkedList<Persona> con personas que fueron leídas del archivo 
de texto con formato dni apellido edad. 
Lanzar la excepción ImposibleLeerArchivo que extiende a IOException en el caso 
que ocurra un error en tiempo de ejecución.

2. Implementar un método estático getPersonasMayoresAEdad que reciba un objeto 
LinkedList<Persona> y una edad y devuelva otro objeto LinkedList<Persona> con 
las personas cuyas edades son mayores a esa edad.

3. Sobreescribir los métodos:
equals de Object para determinar que dos objetos personas son iguales si sus dni´s son iguales.
toString de Object para aplanar el objeto a una cadena que contiene los colaboradores 
internos del objeto separado por “;”.

 
 */


public class Saracatunga {
	
	public static LinkedList<Persona> getPersonas(String archivo)  {
		LinkedList<Persona> personas = new LinkedList<Persona>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));
			//sc.useDelimiter(" ");
			
			while(sc.hasNext())	
				
				personas.add(new Persona(sc.nextInt(), sc.next(), sc.nextInt()));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sc.close();
			
		
		return personas;
	}
	
	public static void ordenarPersonasPorDNI(List<Persona> lista) {
		Collections.sort(lista,new DniComparator());
	}
	
	public static void ordenarPersonasPorEdad(List<Persona> lista) {
		Collections.sort(lista, new EdadComparator());
	}
	
	public static LinkedList<Persona> getPersonasMayoresDeEdad(List<Persona> personas, Integer edad) {
		LinkedList<Persona> personasMayores = new LinkedList<Persona>();
		
		for(Persona cu : personas)
			if(cu.getEdad() > edad)
				personasMayores.add(cu);
		
		return personasMayores;
		
	}
	
	public static void main(String[] args)  {
		
		
		List<Persona> personitas;
		personitas=Saracatunga.getPersonas("personas.in");
		
		ordenarPersonasPorDNI(personitas);
		
		for(Persona cu : personitas)
			System.out.println(cu);
		
		List<Persona> viejitas = Saracatunga.getPersonasMayoresDeEdad(personitas, 25);
		System.out.println("----------------------------------------");
		ordenarPersonasPorEdad(viejitas);
		
		for(Persona cu : viejitas)
			System.out.println(cu);
	}

}
