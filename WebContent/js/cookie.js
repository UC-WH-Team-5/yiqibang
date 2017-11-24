function getCookieValue(key) {
	var cookies = document.cookie;
	// lastLoginDate=1508919505213;SEESION=FADLFDAJDAF
	var cookieArr = cookies.split(";"); // 将字符串按照;进行分割成数组
	for (var i = 0; i < cookieArr.length; i++) {// 对分割后的数组进行遍历
		// lastLoginDate=1508919505213
		var cookieI = cookieArr[i];
		var cookieIArr = cookieI.split("="); // 将遍历到的一个用=连接的键值对分割成一个长度为2数组
		if (cookieIArr[0] == key) {// cookieIArr[0]为cookie的key
			return cookieIArr[1];// cookieIArr[1]为cookie的value
		}
	}
	return null;
}





