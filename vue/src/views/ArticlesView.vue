<template>
  <h1>Articles</h1>
    <section id="articles-pics">
      <div class="articles-pics1"><a href="https://riordanclinic.org/2018/03/13-health-benefits-of-coffee-based-on-science/?gclid=Cj0KCQiAsburBhCIARIsAExmsu76rAuS3rnEO2lznJSxaKKwz8erMeb-IEj_v6c1q9rGZAkSqsr1ehYaAqYOEALw_wcB"><img src="src\assets\health2.webp"></a></div>
      <div class="articles-pics2"><a href="https://www.medscape.com/viewarticle/994049?form=fpf"><img src="src\assets\brainBoosting.jpeg"></a></div>
      <div class="articles-pics3"><a href="https://www.nytimes.com/2023/09/26/well/eat/coffee-benefits-caffeine-risks.html"><img src="src\assets\tooMuch.jpeg"></a></div>
      <div class="articles-pics4"><a href="https://www.inc.com/geoffrey-james/scientists-just-discovered-best-time-of-day-to-drink-your-first-cup-of-coffee.html"><img src="src\assets\bestTime1.jpeg"></a></div>
    </section>
    <section id="articles-texts">
      <div class="articles-texts1"><a href="https://riordanclinic.org/2018/03/13-health-benefits-of-coffee-based-on-science/?gclid=Cj0KCQiAsburBhCIARIsAExmsu76rAuS3rnEO2lznJSxaKKwz8erMeb-IEj_v6c1q9rGZAkSqsr1ehYaAqYOEALw_wcB">Health Benefits of Coffee</a></div>
      <div class="articles-texts2"><a href="https://www.medscape.com/viewarticle/994049?form=fpf">Coffee Brain Boosting Effect</a></div>
      <div class="articles-texts3"><a href="https://www.nytimes.com/2023/09/26/well/eat/coffee-benefits-caffeine-risks.html">How much is too much Coffee?</a></div>
      <div class="articles-texts4"><a href="https://www.inc.com/geoffrey-james/scientists-just-discovered-best-time-of-day-to-drink-your-first-cup-of-coffee.html">Best Time to Drink Coffee</a></div>
    </section>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');
h1{
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Ubuntu', sans-serif;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-weight: bolder;
  font-size: 275%;
}
#articles-pics {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}
.articles-pics1 {
  border: 20px solid white;
  resize: both;
}
.articles-pics2 {
  border: 20px solid white;
  resize: both;
}
.articles-pics3 {
  border: 20px solid white;
  resize: both;
}
.articles-pics4 {
  border: 20px solid white;
  resize: both;
}
.articles-texts1 {
  display: flex;
  flex-direction: row;
  position: relative;
  left: 275px;
  bottom: 800px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 790;
  font-size: 200%;
  color:azure;
  text-decoration: none;
}
.articles-texts2 {
  display: flex;
  flex-direction: row;
  position: relative;
  left: 890px;
  bottom: 843px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 790;
  font-size: 200%;
}
.articles-texts3 {
  display: flex;
  flex-direction: row;
  position: relative;
  left: 225px;
  bottom: 445px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 790;
  font-size: 200%;
}
.articles-texts4 {
  display: flex;
  flex-direction: row;
  position: relative;
  left: 900px;
  bottom: 488px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 790;
  font-size: 200%;
}
/* #articles-texts:link, #articles-texts:visited {
  color:aliceblue;

} */
</style>