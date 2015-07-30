/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocsfinweb.dao;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author MAXWELLPAYNE
 */
public class OCSFINWEBLOGINDAO {
    public boolean authenticateldap(String adusername,String adpassword)throws Exception
	{
		/*boolean authentic=false;
                String ldapstring="ldap://172.28.0.31:389";                
		LdapContext ctx=null;
		//Rdn rdn=new Rdn(adusername);
		//Rdn rdn=new Rdn("cn","example,mpayne");
		//String rdn ="cn="+adusername+",dc=example,dc=com,ou=People";
		try
		{
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.SECURITY_AUTHENTICATION,"Simple");
			env.put(Context.SECURITY_PRINCIPAL,"ICRAF\\"+adusername);
			env.put(Context.SECURITY_CREDENTIALS,adpassword);
			env.put(Context.PROVIDER_URL,ldapstring);
			ctx = new InitialLdapContext(env,null);
			authentic=true;
		}
		catch(Exception ex)
		{
			throw new Exception(ex);
		}
		
		
		return authentic;
                //return true;*/
            boolean authentic=false;
                //String ldapstring="ldap://ICRAFAD02.ICRAF.CGIARAD.ORG:389";
                String ldapstring="";
                String[] parts=adusername.split("\\\\");
                String domain=parts[0].toUpperCase();
                if(domain.equals("ICRAF"))
                {
                    ldapstring="ldap://172.28.0.18:389";
                
                }
                if(domain.equals("CGIARAD"))
                {
                    ldapstring="ldap://172.28.0.30:389";
                
                }
                if(domain.isEmpty())
                {
                    ldapstring="ldap://ldap.oe5.cgiar.org:389";
                
                }
		LdapContext ctx=null;
		//Rdn rdn=new Rdn(adusername);
		//Rdn rdn=new Rdn("cn","example,mpayne");
		//String rdn ="cn="+adusername+",dc=example,dc=com,ou=People";
		try
		{
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.SECURITY_AUTHENTICATION,"Simple");
			env.put(Context.SECURITY_PRINCIPAL,adusername);
			env.put(Context.SECURITY_CREDENTIALS,adpassword);
			env.put(Context.PROVIDER_URL,ldapstring);
			ctx = new InitialLdapContext(env,null);
			authentic=true;
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		
		return authentic;
                //return true;
            
	}
    
}
