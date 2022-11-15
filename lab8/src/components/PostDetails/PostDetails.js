import React, { useEffect, useState } from 'react';
import './PostDetails.css';
import Comment from '../Comment/Comment';
import axios from 'axios';


const PostDetails = (props) => {

    const [postDetail, setPostDetail] = useState({});

    useEffect(
        () => {
            axios.get('posts/' + props.id)
                .then(response => {
                    setPostDetail(response.data)
                    // console.log("RESPONSE:", response.data)
                })
                .catch(err => console.log(err.message))
        },
        [props.id])

    let postDetailsDisplay = null;

    if (props.id !== 0) {

        postDetailsDisplay = (

            <div className="PostDetails">
                <h1>Post Details</h1>
                <h3>{postDetail.title}</h3>
                <div>
                    <i>{postDetail.author}</i>
                    <br />
                    <div className='content' style={{ textAlign: "left" }}>
                        {postDetail.content}
                    </div>
                </div>
                <div style={{ textAlign: "left" }}>
                        Comments <br />
                        <ul>
                        {postDetail.comments != null ? postDetail.comments.map(comment => {
                            return <Comment comment={comment} key={comment.id}/>
                        }) : null}
                        </ul>
                </div>
                <input type="button" value="Edit" />
                <input type="button" value="Delete" onClick={() => { props.deletePost(props.id) }} />
            </div>
        );
    }

    return postDetailsDisplay;



}

export default PostDetails;