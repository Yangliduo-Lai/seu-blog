<template>
    <div class="templates">
    <h1>semantics 1</h1>

    <ul class="article-list">
        <li v-for="article in articles" :key="article.id">
            <a href="#">{{ article.title }}</a>
            <span>{{ article.date }}</span>
            <hr/>
        </li>
    </ul>
    </div>
</template>
  <script>
  export default {
    data() {
      return {
        articles: [
          { id: 1, title: 'Ambiguity in template parameters', date: '2024/10/10' }
          // 更多文章可以加在这里
        ]
      };
    }
  }
  </script>

<style scoped>
.semantics {
  height: calc(100vh - 60px); /* Adjusting the height to create a clean, unified look */
  overflow-y: auto; /* Ensures content is scrollable when exceeds container's height */
  margin: 20px; /* Provides uniform space around the container */
  padding: 0 20px 20px 20px; /* Right padding adjusted to provide a consistent internal spacing */
  background: #fff; /* Bright and clean background color */
  box-shadow: 0 4px 10px rgba(0,0,0,0.1); /* Subtle shadow for depth */
}

.semantics h1 {
  font-size: 24px; /* Slightly reduced for proportionate scaling */
  color: #333; /* Dark gray for better readability */
  padding-bottom: 5px; /* Reduced padding for a tighter header */
  margin-bottom: 20px; /* Consistent bottom margin */
  border-bottom: 2px solid #ddd; /* Subtle border for separation */
}

.article-list {
  list-style-type: none; /* No bullets */
  padding: 0; /* No padding to align with the design requirements */
  margin: 0; /* No margin to keep the elements compact */
}

.article-list li {
  margin-bottom: 20px; /* Increased spacing between entries for clarity */
  padding-bottom: 10px; /* Padding above the separator */
  border-bottom: 1px solid #eee; /* Lighter and thinner border for a minimalist look */
}

.article-list a {
  text-decoration: none; /* Removing underline from links */
  color: #4A90E2; /* Maintaining the thematic blue */
  font-size: 18px; /* Appropriate font size for readability */
  transition: color 0.3s ease; /* Smooth transition for hover effect */
}

.article-list a:hover {
  color: #2a6fbd; /* A darker shade of blue on hover for interactive feedback */
}

.article-list span {
  float: right; /* Ensures date is aligned to the right */
  color: #aaa; /* Light grey for subtle information */
  font-size: 14px; /* Small and non-intrusive font size */
  margin-top: 0; /* Aligned properly with the title */
}

/* Removing horizontal rules entirely for a clean look */
.article-list hr {
  display: none;
}
</style>
