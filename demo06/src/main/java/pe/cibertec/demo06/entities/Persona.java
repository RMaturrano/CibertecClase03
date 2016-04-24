package pe.cibertec.demo06.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android-SAB-PM on 23/04/2016.
 */
public class Persona implements Parcelable {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona() {
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        dni = in.readString();
        edad = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(dni);
        dest.writeInt(edad);
    }

    @SuppressWarnings("unused")
    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
}
