package com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity;

import java.io.Serializable;

public class ProveedorJoinContacto implements Serializable {
    private Proveedor proveedor;
    private ContactoInfo contactoInfo;

    public ProveedorJoinContacto(){
        proveedor = null;
        contactoInfo=null;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ContactoInfo getContactoInfo() {
        return contactoInfo;
    }

    public void setContactoInfo(ContactoInfo contactoInfo) {
        this.contactoInfo = contactoInfo;
    }
}
