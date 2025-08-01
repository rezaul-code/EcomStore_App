document.addEventListener("DOMContentLoaded", () => {
  const toggleBtn = document.getElementById('theme-toggle');
  if (!toggleBtn) return;

  // Set label text
  const setButtonLabel = (isDark) => {
    toggleBtn.textContent = isDark ? 'Light Mode' : 'Dark Mode';
  };

  // Apply saved theme
  const savedTheme = localStorage.getItem('theme');
  const isDarkSaved = savedTheme === 'dark';
  if (isDarkSaved) {
    document.body.classList.add('dark-mode');
  }
  setButtonLabel(isDarkSaved);

  // Toggle theme on click
  toggleBtn.addEventListener('click', () => {
    document.body.classList.toggle('dark-mode');
    const isDark = document.body.classList.contains('dark-mode');
    setButtonLabel(isDark);
    localStorage.setItem('theme', isDark ? 'dark' : 'light');
  });
});
