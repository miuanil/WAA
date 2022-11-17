import React, { useEffect, useState, useContext } from 'react';
import './PostDetails.css';
import Comment from '../Comment/Comment';
import axios from 'axios';
import { SelectedId } from "../../context/SelectedId";

const PostDetails = (props) => {

    const idContext = useContext(SelectedId);
    const [postDetail, setPostDetail] = useState({});

    useEffect(
        () => {
            axios.get('posts/' + idContext.id)
                .then(response => {
                    setPostDetail(response.data)
                })
                .catch(err => console.log(err.message))
        },
        [idContext.id])

    let postDetailsDisplay = null;

    if (idContext.id !== 0) {

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
                            return <Comment comment={comment} key={comment.id} />
                        }) : null}
                    </ul>
                </div>
                <input type="button" value="Edit" />
                <input type="button" value="Delete" onClick={() => { props.deletePost(idContext.id) }} />
            </div>
        );
    }

    return postDetailsDisplay;
}

export default React.memo(PostDetails);