import React, { useEffect, useState } from 'react';
import Posts from '../../containers/Posts/Posts';
import PostDetails from '../../components/PostDetails/PostDetails';
import './Dashboard.css';
import axios from 'axios';
import AddPost from '../../components/AddPost/AddPost';

const AUTH_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huQGRvZS5jb20iLCJleHAiOjE2Njg1NTE0MTAsImlhdCI6MTY2ODU1MDMzMH0.9MBER4umtpGfYcfq83vYx8-dxzIRq9nmTrOtpikd5B6wVvq6dSlZ8zh94OUcc3rU88L0MmblUBp43Izx8L9LBg";

axios.defaults.baseURL = 'http://localhost:8080/api/v1/'
axios.defaults.headers.common['Authorization'] = `Bearer ${AUTH_TOKEN}`;

export default function Dashboard() {

    const [newTitleState, setNewTitleState] = useState("");
    const [selectedState, setSelectedState] = useState(0);

    const [postsState, setPostsState] = useState(
        [
            { id: 111, title: "Happiness", author: "John", content: 'This is the content in the post#111' },
            { id: 112, title: "MIU", author: "Dean", content: 'This is the content in the post#112' },
            { id: 113, title: "Enjoy Life", author: "Jasmine", content: 'This is the content in the post#113' },
        ]
    );

    const [postState, setPostState] = useState(
        {
            title: "",
            author: "",
            content: ""
        }
    )

    const setSelected = (id) => {
        setSelectedState(id);
    }

    const onChangeFirstTitle = (events) => {
        setNewTitleState(events.target.value);
    }

    const onChange = (events) => {
        const copy = { ...postState };
        copy[events.target.name] = events.target.value;
        setPostState(copy);
    }

    const addButtonClicked = () => {
        axios.post('posts', postState)
            .then(response => {
                setPostState(response);
                fetchPosts();
            });
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
            .then(response => {
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
                setSelected(0);
            })
            .catch(err => {
                console.log(err);
            })
    }

    useEffect(() => {
        fetchPosts();
    }, [])

    return (
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
                <AddPost
                    title={postState.title}
                    author={postState.author}
                    content={postState.content}
                    onChange={(event) => { onChange(event) }}
                    addButtonClicked={addButtonClicked}
                />
            </div>
            <div className='Posts'>
                <Posts
                    posts={postsState}
                    setSelected={setSelected}
                />
            </div>
            <div>
                <PostDetails
                    id={selectedState}
                    deletePost={deleteButtonClicked}
                />
            </div>
        </div>
    )

};
