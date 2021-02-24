import React from "react";
import NewsItem from "./NewsItem";
import news from './news';
import "./style.css";

function Home() {
  const mapNewsItem = news.map((item, index) => {
    return <NewsItem key={index} newsItem={item} />;
  });

  return (
    <div>
      <div className="news-section p-4">
        <h5 className="mb-3">PTIT news : </h5>
        {mapNewsItem}
      </div>
    </div>
  );
}

export default Home;
