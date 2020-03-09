package cn.dz.daima.utils;

import com.offtake.common.Const;
import com.offtake.common.util.DateUtil;
import com.offtake.common.util.EasyImage;

import java.io.*;

public class FileUtil {

	public static String readFile(String fileName) throws IOException {
		File file = new File(fileName);

		if (!file.exists()) {
			return null;
		}

		if (!file.isFile()) {
			return null;
		}

		BufferedReader input = new BufferedReader(new FileReader(file));
		StringBuffer buffer = new StringBuffer();

		String text;
		while ((text = input.readLine()) != null) {
			buffer.append(text);
		}

		return buffer.toString();
	}

	public static void saveFile(File file, String path, String fileName) {
		InputStream in = null;
		FileOutputStream fos = null;
		byte[] buffer = new byte[1024];
		try {
			in = new FileInputStream(file);
			String savePath = path + fileName;

            File fPath = new File(savePath);
            if (!fPath.getParentFile().exists()) {
                fPath.getParentFile().mkdirs();
            } else if (!fPath.getParentFile().isDirectory()) {
                fPath.getParentFile().delete();
                fPath.getParentFile().mkdirs();
            }
			fos = new FileOutputStream(savePath);
			int num = 0;
			while ((num = in.read(buffer)) > 0) {
				fos.write(buffer, 0, num);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void saveCamaraFile(File file, String path, String fileName) {
		InputStream in = null;
		FileOutputStream fos = null;
		byte[] buffer = new byte[1024];
		try {
			in = new FileInputStream(file);
			String savePath = path + fileName;

            File fPath = new File(savePath);
            if (!fPath.getParentFile().exists()) {
                fPath.getParentFile().mkdirs();
            } else if (!fPath.getParentFile().isDirectory()) {
                fPath.getParentFile().delete();
                fPath.getParentFile().mkdirs();
            }
			fos = new FileOutputStream(savePath);
			int num = 0;
			while ((num = in.read(buffer)) > 0) {
				fos.write(buffer, 0, num);
			}

			//保存缩略图
			saveThumbnailImage(path, fileName);

		} catch (Throwable e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void saveCamaraFile(byte[] bytes, String path, String fileName) {
		FileOutputStream fos = null;
		try {
			String savePath = path + fileName;

			File fPath = new File(savePath);
			if (!fPath.getParentFile().exists()) {
				fPath.getParentFile().mkdirs();
			} else if (!fPath.getParentFile().isDirectory()) {
				fPath.getParentFile().delete();
				fPath.getParentFile().mkdirs();
			}

			fos = new FileOutputStream(savePath);
			fos.write(bytes);
			
			//保存缩略图
			saveThumbnailImage(path, fileName);
			
		} catch (Throwable e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void saveFile(byte[] bytes, String path, String fileName) {
		FileOutputStream fos = null;
		try {
			String savePath = path + fileName;
			fos = new FileOutputStream(savePath);
			fos.write(bytes);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String getRadomName() {
		return getRadomName(null);
	}

	public static String getRadomName(String filename) {
		StringBuilder ret = new StringBuilder();
		ret.append(DateUtil.formateDate(DateUtil.getCurrentDate(),
				"yyyyMMddHHmmssss"));
		ret.append((int) ((Math.random() * 9 + 1) * 1000));
		if (filename != null) {
			String ext = filename.substring(filename.lastIndexOf(".") + 1,
					filename.length()).toLowerCase();
			ret.append(".");
			ret.append(ext);
		}
		return ret.toString();
	}
	public static String getAddPath()
	{
		StringBuffer addFilePath = new StringBuffer();
		addFilePath.append(DateUtil.formateDate(DateUtil.getCurrentDate(), "yyyy"));
		addFilePath.append("/");
		addFilePath.append(DateUtil.formateDate(DateUtil.getCurrentDate(), "MM"));
		addFilePath.append("/");
		addFilePath.append(DateUtil.formateDate(DateUtil.getCurrentDate(), "dd"));
		addFilePath.append("/");
		return addFilePath.toString();
	}
	/**
	 * 
	 * 创建缩略图
	 * 
	 * @param path
	 * @param fileName
	 */
	private static void saveThumbnailImage(String path, String fileName) {

		String savePath = path + fileName;

		try {
            File file = new File(savePath);
            if(file==null)
            	return;
            String savePathT = new File(file.getParentFile(), Const.CAMARA_IMAGE_THUMBNAIL_IMAGE_EX + file.getName()).toString();
//            ImageUtil.resize(savePath, savePathT, 80);
            EasyImage image  = new EasyImage(savePath);
			image.resize(10);
			image.saveAs(savePathT);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
