package dev.ivanhdzd.app;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	/**
	 * Make a dates list.
	 *
	 * @param count number of days to get from now.
	 * @return Dates list from now to count days next.
	 */
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Date start = new Date(); // Today's date
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); // Get next days from now
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);

		List<String> nextDays = new ArrayList<String>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}

	/**
	 * Save an image into server.
	 *
	 * @param multipart file get from form.
	 * @return image name.
	 */
	public static String saveFile(MultipartFile multipart, String path) {
		String name = randomAlphaNumeric(8) + multipart.getOriginalFilename().replace(" ", "-");
		try {
			File imageFile = new File(path + name);
			multipart.transferTo(imageFile);
			return name;
		} catch (Exception e) {
			System.out.println("[ERROR] Util.saveFile:" + e.getMessage());
			return null;
		}
	}

	/**
	 * Generate a random alpha numeric string.
	 *
	 * @param count number of characters to generate.
	 * @return random string generated.
	 */
	public static String randomAlphaNumeric(int count) {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQESTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- > 0) {
			int index = (int) (Math.random() * CHARACTERS.length());
			builder.append(CHARACTERS.charAt(index));
		}
		return builder.toString();
	}
}