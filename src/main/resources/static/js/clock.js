function updateTime() {
  var date = new Date();

  var hr;
  var min =
    date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
  var sec =
    date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
  var ampm = date.getHours() > 12 ? "PM" : "AM";

  if (hr == 0) {
    hr = 12;
  } else if (hr > 12) {
    hr = date.getHours() - 12;
  } else {
    hr = date.getHours();
  }

  var currentTime = hr + ":" + min + ":" + sec;

  document.getElementsByClassName("hms")[0].innerHTML = currentTime;

  document.getElementsByClassName("ampm")[0].innerHTML = ampm;

  var days = [
    "(日)",
    "(月)",
    "(火)",
    "(水)",
    "(木)",
    "(金)",
    "(土)"
  ];

  var months = [
    "1月",
    "2月",
    "3月",
    "4月",
    "5月",
    "6月",
    "7月",
    "8月",
    "9月",
    "10月",
    "11月",
    "12月"
  ];

  var day = date.getDay();
  var month = date.getMonth();
  var dates = date.getDate();
  console.log(day);
  console.log(month);
  var currentDate = months[month] + " " +  dates + "日" + " " + days[day];

  document.getElementsByClassName("date")[0].innerHTML = currentDate;
}

updateTime();
setInterval(function () {
  updateTime();
}, 1000);
