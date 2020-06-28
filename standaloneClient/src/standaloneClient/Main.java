package standaloneClient;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
//import javax.naming.NamingException;

import com.example.FirstStatelessEjbRemote;


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Properties;
//
//import javax.naming.InitialContext;

public class Main {
	
	public static void main(String[] args) {
		Properties jndiProps = System.getProperties();
		jndiProps.put("org.omg.CORBA.ORBInitialHost", "ec2-54-167-178-1.compute-1.amazonaws.com");
		jndiProps.put("org.omg.CORBA.ORBInitialPort","3700");
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		jndiProps.put(Context.PROVIDER_URL, "com.sun.enterprise.naming");
		jndiProps.put(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		System.setProperties(jndiProps);
		Context context;
		try {
			context = new InitialContext(jndiProps);
		
		FirstStatelessEjbRemote firstEjb = (FirstStatelessEjbRemote) context.lookup("java:global/com.example.FirstStatelessEjbRemote#com.example.FirstStatelessEjbRemote");
		firstEjb.insert("Teo", "parola");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//
//			URL url = new URL("https://8jalp6xan2.execute-api.us-east-1.amazonaws.com/testpets/pets");
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestMethod("GET");
//			conn.setRequestProperty("Accept", "application/json");
//
//			if (conn.getResponseCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ conn.getResponseCode());
//			}
//
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//				(conn.getInputStream())));
//
//			String output;
//			StringBuilder result = new StringBuilder();
//			System.out.println("Output from Server .... \n");
//			while ((output = br.readLine()) != null) {
//				result.append(output);
//				System.out.println(output);
//			}
//			System.out.println("result");
//			System.out.println(result);
//
//			conn.disconnect();
//
//		  } catch (MalformedURLException e) {
//
//			e.printStackTrace();
//
//		  } catch (IOException e) {
//
//			e.printStackTrace();
//
//		  }
	}

}
