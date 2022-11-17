import React, { useEffect, useState } from 'react';
import Posts from '../../containers/Posts/Posts';
import PostDetails from '../../components/PostDetails/PostDetails';
import { SelectedId } from "../../context/SelectedId";
import './Dashboard.css';
import axios from 'axios';
import AddPost from '../../components/AddPost/AddPost';

const AUTH_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huQGRvZS5jb20iLCJleHAiOjE2Njg1NTE0MTAsImlhdCI6MTY2ODU1MDMzMH0.9MBER4umtpGfYcfq83vYx8-dxzIRq9nmTrOtpikd5B6wVvq6dSlZ8zh94OUcc3rU88L0MmblUBp43Izx8L9LBg";

axios.defaults.baseURL = 'http://localhost:8080/api/v1/'
axios.defaults.headers.common['Authorization'] = `Bearer ${AUTH_TOKEN}`;

export default function Dashboard() {

    const [newTitleState, setNewTitleState] = useState("");
    const [selectedState, setSelectedState] = useState({ id: 0 });

    const [postsState, setPostsState] = useState(
        [
            { id: 111, title: "Happiness", author: "John", content: 'This is the content in the post#111' },
            { id: 112, title: "MIU", author: "Dean", content: 'This is the content in the post#112' },
            { id: 113, title: "Enjoy Life", author: "Jasmine", content: 'This is the content in the post#113' },
        ]
    );

    const onChangeFirstTitle = (events) => {
        setNewTitleState(events.target.value);
    }

    const changeFirstPostsTitle = () => {
        if (postsState.length > 0) {
            let title = newTitleState !== "" ? newTitleState : "Happiness";
            const copyPosts = [...postsState];
            copyPosts[0].title = title;
            setPostsState(copyPosts);
        }
    }

    const deleteButtonClicked = (id) => {
        axios.delete('posts/' + id, postsState)
            .then(resp => {
                fetchPosts();
            })
            .catch(err => {
                console.error(err);
            })
    }

    const fetchPosts = () => {
        axios.get("posts")
            .then(resp => {
                setPostsState(resp.data);
                setSelectedState({ id: 0 });
            })
            .catch(err => {
                console.log(err);
            })
    }

    useEffect(() => {
        fetchPosts();
    }, [])

    const selectedIdHandler = (id) => {
        setSelectedState({id: id});
    }

    return (
        <React.Fragment>
            <SelectedId.Provider value={selectedState}>
                <div>

                    <div className='form'>
                        <h2>Change First Posts' Title</h2>
                        <input
                            type="text"
                            id="title"
                            name={newTitleState}
                            onChange={(event) => { onChangeFirstTitle(event) }}
                        />
                        <input
                            type="button"
                            value="Change Name"
                            onClick={changeFirstPostsTitle}
                        />
                    </div>
                    <div className='addPost'>
                        <AddPost />
                    </div>
                    <div className='Posts'>
                        <Posts
                            posts={postsState}
                            selectedIdHandler={selectedIdHandler}
                        />
                    </div>
                    <div>
                        <PostDetails
                            id={selectedState.id}
                            deletePost={deleteButtonClicked}
                        />
                    </div>
                </div>
            </SelectedId.Provider>
        </React.Fragment>
    )
};
