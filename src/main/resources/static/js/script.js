console.log("Script loaded successfully.");

let currentTheme = getTheme();
 changeTheme();

// Function to toggle the theme\
function changeTheme(){
     // set to web page
     document.querySelector("html").classList.add(currentTheme);

     // set the listener to change buttonand icon
     const changeThemeButton =  document.querySelector("#theme_change_button")
     changeThemeButton.addEventListener("click", () => {
      console.log("Theme change button clicked");
       if (currentTheme === "dark") {
         currentTheme = "light";
         changeThemeButton.innerHTML = `<i class="fa-solid fa-sun"></i> <span>Dark</span>`;
       } else {
         currentTheme = "dark";
         changeThemeButton.innerHTML = `<i class="fa-solid fa-moon"></i> <span>Light</span>`;
       }
       // set the theme to local storage
       setTheme(currentTheme);
       // set the theme to web page
       document.querySelector("html").classList.remove("light", "dark");
       document.querySelector("html").classList.add(currentTheme);
     });
    }

//set theme to local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// get theme fro local storage
function getTheme() {
  return localStorage.getItem("theme") || "light"; // default to light theme
}