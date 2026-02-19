export default function getAgeInMonths(birthDateString) {
  const birthDate = new Date(birthDateString);
  const today = new Date();

  let years = today.getFullYear() - birthDate.getFullYear();
  let months = today.getMonth() - birthDate.getMonth();

  // Adjust if the current day is before the birth day
  if (today.getDate() < birthDate.getDate()) {
    months--;
  }

  const totalMonths = years * 12 + months;
  return totalMonths >= 0 ? totalMonths : 0; // avoid negative months
}


