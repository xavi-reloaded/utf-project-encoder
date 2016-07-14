package BD;


/**
 *
 * <p>Title: Projecte</p>
 * <p>Description: proves </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Solucions</p>
 *  <p>Aquesta classe  <code> Camp </code> serveix per guardar les característiques d'un camp
       determinat d'una bd per l'utilitat de generar cadenes sql de forma automàmica a partir d'unes
       certes dades.
    </p>
 * @author xvalero
 * @version 1.0
 */

public class Camp {

//Atributs

  /**
   * Indica el nom del camp que hem establert directament o hem recuperat d'una determinada taula de la bd.
   */
  private String nomcamp;

  /**
   * Indica el tipus de camp que hem recuperat d'una determinada taula de la bd.
   */
  private String tipuscamp;//Si és un paràmetre el tipus serà "Parametre"

  /**
   * Indica el valor del camp en forma de cadena que li passarem a la sentència SQL.
   */
  private String valorcamp; //li passo valor en forma de String

//Constructor

  /**
   * Constructor de la classe inicialitzant els atributs com a cadenes buides (" ");
  */
  public Camp() {
    this.nomcamp = "";
    this.tipuscamp = "";
    this.valorcamp = "";    
  }

  /**
   * Constructor que incia el nom,tipus  i valor en forma de cadena que establim o
     hem recuperat de la taula de bd.
   * @param nc nom del camp
   * @param tc tipus de camp
   * @param vc valor del camp en forma de cadena
  */
  public Camp(String nc, String tc, String vc) {
    this.nomcamp = nc;
    this.tipuscamp = tc;
    this.valorcamp = vc;
  }
  
  public Camp(String nc) {
	    this.nomcamp = nc;
	    this.tipuscamp = "";
	    this.valorcamp = "";
  }

  //Consultores

  /**
   * Consulta el nom camp .
   * @return String
  */
  public String nom() {
    return this.nomcamp;
  }

  /**
   * Consulta el tipus de camp que pot ser "INTEGER,VARCHAR,...,etc" .
   * @return String
  */
  public String tipus() {
    return this.tipuscamp;
  }

  /**
   * Consulta el valor en forma de cadena .
   * @return String
  */
 public String valor() {
    return this.valorcamp;
  }

  public void setvalor(String val) {
    this.valorcamp=val;
   }


}
