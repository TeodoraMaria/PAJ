package standaloneClient;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.example.FirstStatelessEjbRemote;

public class Main {
	
	public static void main(String[] args) throws NamingException {
		Properties jndiProps = new Properties();
		jndiProps.put("org.omg.CORBA.ORBInitialHost", "ec2-54-174-202-76.compute-1.amazonaws.com");
		jndiProps.put("org.omg.CORBA.ORBInitialPort","4848");
//		jndiProps.put("java.naming.factory.initial","javax.naming.spi.InitialContextFactory");
//		jndiProps.put("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
//		jndiProps.put("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		Context context = new InitialContext(jndiProps);
		FirstStatelessEjbRemote firstEjb = (FirstStatelessEjbRemote) context.lookup("com.example.FirstStatelessEjbRemote#com.example.FirstStatelessEjbRemote");
		firstEjb.insert("Teo", "parola");
	}

}
