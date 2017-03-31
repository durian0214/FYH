package com.example.bspatchlibrary;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.DisplayMetrics;

public class SignatureUtils {

	
	/**
	 *  获取一个已经安装的应用的签名
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static String getAppSign(Context context, String packageName){
		PackageManager pm = context.getPackageManager();
		List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.GET_SIGNATURES);
		for (PackageInfo pkg : packages) {
			if (packageName.equals(pkg.packageName)) {
				return pkg.signatures[0].toCharsString();
			}
		}
		
		return null;
	}
	
	
	
	/**
	 * 获取一个APK文件的签名
	 * @param path APK文件的路径
	 * @return
	 */
	public static String getApkSign(String path){
		String packageParserStr = "android.content.pm.PackageParser";
		//方法的参数类型
		Class<?>[] typeArgs = new Class[1];
		
		//方法需要传入的参数值 
		Object[] valueArgs = new Object[1];
		
		try {
			//实例化PackageParser对象
			Class<?> pkgParserCls = Class.forName(packageParserStr);
			typeArgs[0] = String.class;
			Constructor<?> pkgParserCt = pkgParserCls.getConstructor(typeArgs);
			valueArgs[0] = path;
			Object pkgParser = pkgParserCt.newInstance(valueArgs);
			
			//执行parsePackage方法
			typeArgs = new Class[4];
			typeArgs[0] = File.class;
			typeArgs[1] = String.class;
			typeArgs[2] = DisplayMetrics.class;
			typeArgs[3] = int.class;
			Method parsePackageMtd = pkgParserCls.getDeclaredMethod("parsePackage", typeArgs);
			
			valueArgs = new Object[4];
			valueArgs[0] = new File(path);
			valueArgs[1] = path;
			DisplayMetrics metrics = new DisplayMetrics();
			metrics.setToDefaults();
			valueArgs[2] = metrics;
			valueArgs[3] = PackageManager.GET_SIGNATURES;
			
			//得到PackageParser.Package对象
			Object pkgParserPkg = parsePackageMtd.invoke(pkgParser, valueArgs);
			
			//执行collectCertificates方法
			typeArgs = new Class[2];
			typeArgs[0] = pkgParserPkg.getClass();
			typeArgs[1] = int.class;
			Method collectCertificatesMtd = pkgParserCls.getMethod("collectCertificates", typeArgs);
			
			valueArgs = new Object[2];
			valueArgs[0] = pkgParserPkg;
			valueArgs[1] = PackageManager.GET_SIGNATURES;
			collectCertificatesMtd.invoke(pkgParser, valueArgs);
			
			//获取mSignatures的属性值
			Field mSignaturesFld = pkgParserPkg.getClass().getDeclaredField("mSignatures");
			Signature[] signatures = (Signature[]) mSignaturesFld.get(pkgParserPkg);
			
			
			return signatures[0].toCharsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
}
