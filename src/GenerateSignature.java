

	
	import java.io.ObjectStreamException;
	import java.security.KeyRep;
	import java.security.PrivateKey;
	import java.security.Signature;
	import java.util.Base64;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Set;
	import java.util.SortedSet;
	import java.util.TreeSet;

	import java.io.ObjectStreamException;
	import java.security.KeyRep;
	import java.security.PrivateKey;
	import java.security.Signature;
	import java.util.Base64;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Set;
	import java.util.SortedSet;
	import java.util.TreeSet;



	public class GenerateSignature {
		
		public static void main(String args[]) {
			GenerateSignature g = new GenerateSignature();
			System.out.println(g.returnSignature(System.currentTimeMillis()));
		}
		
		public String returnSignature(long inTimestamp) {
			
			GenerateSignature generator = new GenerateSignature();
	        String consumerId = "810faacf-ecb6-4ed7-8fdc-7377449809b2";	
	        String privateKeyVersion = "2";     
	        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDAY3DhLugaPmrO\n" + 
	        		"Q8LbkxwH6ZVZeaFB2icbUjy0JFlDxqK7ciwfck09QpOHnpsnqgrGW3GTsfu0Gsqk\n" + 
	        		"VtHjUVuHWbZW+2J9lQhK3OkRXDTQich+RcUnF2FPv2S4WF62en22GtLxEIC31OBw\n" + 
	        		"YZcti21qthxLcbQ1iCn11WINnMpndZEQHKcm30CW1QFFIg6wgr88jnny0DkvJIgG\n" + 
	        		"UcboI6PBSNaljj0QLyqzSAxqvU64nGLjmPzqES+/a8rxqaRyhLbInGfpnlUfluch\n" + 
	        		"NjWcDGai+JKu4oGpJCiJgvvDnCTyMirBpGaBtpdAa287B2H/vY8PgUvHbD0LZ7/h\n" + 
	        		"n72S3uz/AgMBAAECggEAaesVbVQ2wqQUh0S1FdATAaQu7ljRWADzwM3wz7inUHIe\n" + 
	        		"i5ZbBmEWdyCdOnAuuZKbZgNYL1kw20JYyEtoOH9FJepVQeQaoEsZiqW+xyj9hsYk\n" + 
	        		"lKhy14e+snoLyJYWZt5fMY/pDIDqbMsNWbHQ2mlFrxdd0odiEIrLlyWIWzg0Euqp\n" + 
	        		"Uy8YYtRPWJT0lAlwk8xge9BPB11p/U9AB2bNM9BqnVtHZg8uDieeekZ17f7z7RoU\n" + 
	        		"bqok7W+YTJYeC883rgzYLKWBLPZGZoDYEaiPEQKRui8XgNmW5zAJ8W8sxM722Pro\n" + 
	        		"XMoQqIksgI9SB81FLPH8dG8ycTY4aXoW7QT4G3E2eQKBgQDrC/iJLLf3Cxf74o2D\n" + 
	        		"8P7ECGEFVbhMXFQVVsByn3fsheWCyB7voLePOmO/t8JXL1BBv828oy5DmIPUU4qo\n" + 
	        		"VRodN5+cluu/qkxaurm0BA5SRfrWiHRUA0WeIIx5TsDuRpsbRus7Unr1oQH1eg1q\n" + 
	        		"hUEKfrgA9hjDthmujS/L14GVGwKBgQDRifWs4Yy2D08CeBJBrGpt/N2CLo/myZiQ\n" + 
	        		"cDAdRVTnUUGI/4XZnKMhrX0SI8BeYU1PgFbF39jT9MwW0OKLfeKpj/t0WsElyDmC\n" + 
	        		"SUOa57km7Qfwo/MxWmmuwx7Ad9ozjk9lpR7yBZB3ve/EsvCqRk664g58KVnR1xma\n" + 
	        		"cyrHpczZ7QKBgQC0mM8O/xgerhxwgiM/1IS7tMBvK+zeZzaH6s8VgyfOyRaOhRsX\n" + 
	        		"/YHsf+2ymgutl4Hv8uKuZScf8uif1My+CB13g4yU8XUUIFJoh/41rcQfPPu9qLzQ\n" + 
	        		"7G6qT9H/Rx6ANinpLHWDcB1f66Uoqu3yAY729GSHAJAImDtlXb/yvJQpLwKBgEN8\n" + 
	        		"Di6uubXM+mJOL3sNP33K6cBKpLfsh4FFUIms0apqRhQMT5yFURjAmj5kW0lKRy7q\n" + 
	        		"o4e5D0k8VxqmDcBlO8HmiFKyA/DaKoNmeyqBpOT/hAYhl2p2twC9AMN2FkVyeOnA\n" + 
	        		"o1XJKv0VpAoSo2YDnMmdkpK0cqQdhbZzjvybzn0FAoGAXI0DLZEZGUtD/JV9voPe\n" + 
	        		"CIJ7aCYNl6siqBQrYVPZJ0TYhBynz20ovABZk5GZJEZq1pWHsZE6CKIJxwNcXzJI\n" + 
	        		"9RVCZK+w4De9cPqh/lfT1x456LjTcXtFWBNhzgywzOXnA4p4iz+/S+eYd88GaBLo\n" + 
	        		"CVgZNXUjZ+QkYiJ6B6C26II=";     
	 
	         
	        
	        Map<String, String> map = new HashMap<>();
	        map.put("WM_CONSUMER.ID", consumerId);
	        map.put("WM_CONSUMER.INTIMESTAMP", Long.toString(inTimestamp));
	        map.put("WM_SEC.KEY_VERSION", privateKeyVersion);

	        String[] array = canonicalize(map);

	        String data = null;

	        try {
	        	data = generator.generateSignature(privateKey, array[1]);
	        } catch(Exception e) {
//	        	Assert.assertTrue(data!=null);
	        	e.printStackTrace();
	        }
			return data;
		}
		
		
		
		public String generateSignature(String key, String stringToSign) throws Exception {
			Signature signatureInstance = Signature.getInstance("SHA256WithRSA");

	        ServiceKeyRep keyRep = new ServiceKeyRep(KeyRep.Type.PRIVATE, "RSA", "PKCS#8", Base64.getDecoder().decode(key));

	        PrivateKey resolvedPrivateKey = (PrivateKey) keyRep.readResolve();

	        signatureInstance.initSign(resolvedPrivateKey);

	        byte[] bytesToSign = stringToSign.getBytes("UTF-8");
	        signatureInstance.update(bytesToSign);
	        byte[] signatureBytes = signatureInstance.sign();

	        String signatureString = Base64.getEncoder().encodeToString(signatureBytes);

	        return signatureString;
	    }

		protected static String[] canonicalize(Map<String, String> headersToSign) {
			StringBuffer canonicalizedStrBuffer=new StringBuffer();
			StringBuffer parameterNamesBuffer=new StringBuffer();
	        Set<String> keySet=headersToSign.keySet();

	        // Create sorted key set to enforce order on the key names
	        SortedSet<String> sortedKeySet=new TreeSet<String>(keySet);
	        for (String key :sortedKeySet) {
	        	Object val=headersToSign.get(key);
	            parameterNamesBuffer.append(key.trim()).append(";");
	            canonicalizedStrBuffer.append(val.toString().trim()).append("\n");
	        }
	        
	        return new String[] {parameterNamesBuffer.toString(), canonicalizedStrBuffer.toString()};
		}
	        
		class ServiceKeyRep extends KeyRep	{
			private static final long serialVersionUID = -7213340660431987616L;

			public ServiceKeyRep(Type type, String algorithm, String format, byte[] encoded) {
				super(type, algorithm, format, encoded);
	        }

	        protected Object readResolve() throws ObjectStreamException {
	        	return super.readResolve();
	        }
		}

	}

