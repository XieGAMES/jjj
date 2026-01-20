// Work schedule functionality

document.addEventListener('DOMContentLoaded', function() {
    const scheduleViewSelect = document.getElementById('schedule-view');
    
    if (scheduleViewSelect) {
        scheduleViewSelect.addEventListener('change', function() {
            const selectedView = this.value;
            updateScheduleView(selectedView);
        });
    }
    
    // Initialize with weekly view as default
    updateScheduleView('weekly');
});

function updateScheduleView(viewType) {
    // In a real implementation, we would update the schedule display based on the selected view
    // This is a placeholder for demonstration purposes
    console.log(`Switching to ${viewType} view`);
    
    // Placeholder for actual view update logic
    switch(viewType) {
        case 'daily':
            console.log('Loading daily schedule view');
            break;
        case 'weekly':
            console.log('Loading weekly schedule view');
            break;
        case 'monthly':
            console.log('Loading monthly schedule view');
            break;
        default:
            console.log('Unknown view type');
    }
}