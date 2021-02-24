import React from 'react'
import { NavLink } from 'react-router-dom';

function NewsItem(props){
    const {newsItem} = props;
    return(
        <div className="news-item">
            <NavLink to="/post" className="news-title mb-3">{newsItem.title}</NavLink>
            <p>{newsItem.content}</p>
            <NavLink to="/post" className="read-more">
                READ MORE <i className="fa fa-arrow-right" aria-hidden="true"></i>
            </NavLink>
        </div>
    )
}

export default NewsItem;