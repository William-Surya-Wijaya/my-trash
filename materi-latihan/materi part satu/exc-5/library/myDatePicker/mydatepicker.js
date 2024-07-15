function formatDate(date) {
  const options = { day: 'numeric', month: 'long', year: 'numeric' };
  return date.toLocaleDateString('en-US', options);
}

function myDatePicker(date_input, date_value){
  const dateInput = date_input;
  const dateValue = date_value;

  let calendarHTML = `
    <div class="header">
      <div id="prevBtn"><i class="fa fa-angle-left" aria-hidden="true"></i></div>
      <h2 id="monthYear">Month Year</h2>
      <div id="nextBtn"><i class="fa fa-angle-right" aria-hidden="true"></i></div>
    </div>
    <div class="days" id="daysContainer"></div>
  `;

  let calenderContainer = document.createElement("div");
  calenderContainer.classList.add('calendar');
  calenderContainer.innerHTML = calendarHTML;
  dateValue.parentElement.appendChild(calenderContainer);

  const daysContainer = document.getElementById("daysContainer");
  const prevBtn = document.getElementById("prevBtn");
  const nextBtn = document.getElementById("nextBtn");
  const monthYear = document.getElementById("monthYear");
  const calendar = calenderContainer;

  let currentDate = new Date();
  let selectedDate = null;

  function handleDayClick(day) {
    selectedDate = new Date(
      currentDate.getFullYear(),
      currentDate.getMonth(),
      day
    );

    dateInput.value = formatDate(selectedDate);
    dateValue.value = currentDate.getFullYear()+'-'+currentDate.getMonth()+'-'+day;
    calendar.style.display = "none";
    renderCalendar();
  }

  function createDayElement(day) {
    const date = new Date(currentDate.getFullYear(), currentDate.getMonth(), day);
    const dayElement = document.createElement("div");
    dayElement.classList.add("day");

    if (date.toDateString() === new Date().toDateString()) {
      dayElement.classList.add("current");
    }
    if (selectedDate && date.toDateString() === selectedDate.toDateString()) {
      dayElement.classList.add("selected");
    }

    dayElement.textContent = day;
    dayElement.addEventListener("click", () => {
      handleDayClick(day);
    });
    daysContainer.appendChild(dayElement);
  }

  function renderCalendar() {
    daysContainer.innerHTML = "";
    const firstDay = new Date(
      currentDate.getFullYear(),
      currentDate.getMonth(),
      1
    );
    const lastDay = new Date(
      currentDate.getFullYear(),
      currentDate.getMonth() + 1,
      0
    );

    monthYear.textContent = `${currentDate.toLocaleString("default", {
      month: "long"
    })} ${currentDate.getFullYear()}`;

    for (let day = 1; day <= lastDay.getDate(); day++) {
      createDayElement(day);
    }
  }

  prevBtn.addEventListener("click", () => {
    currentDate.setMonth(currentDate.getMonth() - 1);
    renderCalendar();
  });

  nextBtn.addEventListener("click", () => {
    currentDate.setMonth(currentDate.getMonth() + 1);
    renderCalendar();
  });

  dateInput.addEventListener("click", () => {
    calendar.style.display = "block";
    positionCalendar();
  });

  document.addEventListener("click", (event) => {
    if (!dateInput.contains(event.target) && !calendar.contains(event.target)) {
      calendar.style.display = "none";
    }
  });

  function positionCalendar() {
    const inputRect = dateInput.getBoundingClientRect();
    calendar.style.top = inputRect.bottom + "px";
    calendar.style.left = inputRect.left + "px";
  }

  window.addEventListener("resize", positionCalendar);

  renderCalendar();
}

