package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;

public class ProveedorContacto implements Serializable {
    private Proveedor proveedor;
    private ContactoInfo contacto;

    public ProveedorContacto(){
        proveedor = null;
        contacto=null;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ContactoInfo getContactoInfo() {
        return contacto;
    }

    public void setContactoInfo(ContactoInfo contactoInfo) {
        this.contacto = contactoInfo;
    }
}
