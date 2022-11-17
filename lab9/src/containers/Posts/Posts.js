import React from 'react';
import Post from '../../components/Post/Post';
import './Posts.css';

const Posts = (props) => {

    const posts = props.posts.map(p => {
        return <Post 
            title={p.title} 
            author={p.author} 
            id={p.id} 
            key={p.id}
            selectedIdHandler={() => props.selectedIdHandler(p.id)}
        />
    });

    return posts;
};


export default Posts;