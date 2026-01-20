// Calendar functionality for maintenance calendar

document.addEventListener('DOMContentLoaded', function() {
    const prevMonthBtn = document.getElementById('prev-month');
    const nextMonthBtn = document.getElementById('next-month');
    const currentMonthSpan = document.getElementById('current-month');
    
    if (prevMonthBtn && nextMonthBtn && currentMonthSpan) {
        let currentDate = new Date();
        updateCalendarDisplay(currentDate);
        
        prevMonthBtn.addEventListener('click', () => {
            currentDate.setMonth(currentDate.getMonth() - 1);
            updateCalendarDisplay(currentDate);
        });
        
        nextMonthBtn.addEventListener('click', () => {
            currentDate.setMonth(currentDate.getMonth() + 1);
            updateCalendarDisplay(currentDate);
        });
    }
});

function updateCalendarDisplay(date) {
    const monthNames = [
        'January', 'February', 'March', 'April', 'May', 'June',
        'July', 'August', 'September', 'October', 'November', 'December'
    ];
    
    const monthYearString = `${monthNames[date.getMonth()]} ${date.getFullYear()}`;
    document.getElementById('current-month').textContent = monthYearString;
    
    // In a real implementation, we would populate the calendar with actual data
    // This is a placeholder for demonstration purposes
    console.log(`Displaying calendar for ${monthYearString}`);
}