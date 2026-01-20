// Main script file for WAM web application

document.addEventListener('DOMContentLoaded', function() {
    // Initialize language switcher
    const langForm = document.querySelector('.lang-form');
    if (langForm) {
        langForm.addEventListener('change', function(e) {
            if (e.target.name === 'lang') {
                this.submit();
            }
        });
    }
    
    // Add responsive navigation toggle if needed
    setupResponsiveNavigation();
});

function setupResponsiveNavigation() {
    // Placeholder for responsive navigation setup
    console.log('Responsive navigation initialized');
}

// Utility functions
function showAlert(message, type = 'info') {
    // Create and show alert element
    const alertDiv = document.createElement('div');
    alertDiv.className = `alert alert-${type}`;
    alertDiv.textContent = message;
    
    // Add to page and remove after delay
    document.body.insertBefore(alertDiv, document.body.firstChild);
    
    setTimeout(() => {
        alertDiv.remove();
    }, 3000);
}